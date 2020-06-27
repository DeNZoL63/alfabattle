package com.alfa.battle.api;

import com.alfa.battle.model.Branches;
import com.alfa.battle.model.BranchesWithDistance;
import com.alfa.battle.model.BranchesWithPredicting;
import com.alfa.battle.model.ErrorResponse;
import com.alfa.battle.repository.BranchesRepo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-06-27T15:13:40.716+04:00")

@Controller
public class BranchesApiController implements BranchesApi {
    public static final int RADIUS_OF_EARTH = 6371;

    @Qualifier("branchesRepo")
    @Autowired
    private BranchesRepo branchesRepo;

    public ResponseEntity getBranchUsingGET(
            @ApiParam(value = "id", required = true) @PathVariable("id") Long id
    ) {

        Branches branches = branchesRepo.findById(id).orElse(null);

        if (branches == null) {
            return new ResponseEntity<ErrorResponse>(new ErrorResponse().status("branch not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Branches>(branches, HttpStatus.OK);
    }

    public ResponseEntity<BranchesWithPredicting> getBranchesWithPredictingUsingGET(
            @ApiParam(value = "dayOgWeek", required = true) @RequestParam(value = "dayOgWeek", required = true) Integer dayOgWeek,
            @ApiParam(value = "hourOfDay", required = true) @RequestParam(value = "hourOfDay", required = true) Integer hourOfDay,
            @ApiParam(value = "id", required = true) @PathVariable("id") Long id
    ) {
        // do some magic!
        return new ResponseEntity<BranchesWithPredicting>(HttpStatus.OK);
    }

    public ResponseEntity getNearBranchUsingGET(@ApiParam(value = "lat", required = true) @RequestParam(value = "lat", required = true) Double lat,
                                                @ApiParam(value = "lon", required = true) @RequestParam(value = "lon", required = true) Double lon
    ) {

        var lat1 = Math.toRadians(lat);
        var lon1 = Math.toRadians(lon);

        var distance = new HashMap<Long, Double>();
        List<Branches> all = branchesRepo.findAll();
        all.forEach(branches -> {
            var lat2 = Math.toRadians(branches.getLat());
            var lon2 = Math.toRadians(branches.getLon());

            var dLon = lon2 - lon1;
            var dLat = lat2 - lat1;

            var a = Math.pow(Math.sin(dLat / 2), 2)
                    + Math.cos(lat1) * Math.cos(lat2)
                    * Math.pow(Math.sin(dLon / 2), 2);

            distance.put(branches.getId(), RADIUS_OF_EARTH * 2 * Math.asin(Math.sqrt(a)));
        });

        AtomicReference<Double> min = new AtomicReference<>(null);
        AtomicReference<Long> minId = new AtomicReference<>(null);
        distance.forEach((aLong, aDouble) -> {
            if (min.get() == null) {
                min.set(aDouble);
                minId.set(aLong);
            } else {
                if (min.get().compareTo(aDouble) > 0) {
                    min.set(aDouble);
                    minId.set(aLong);
                }
            }
        });

        if (minId.get() != null) {
            Branches branches = branchesRepo.findById(minId.get()).orElse(null);
            if (branches != null) {
                var withDistance = new BranchesWithDistance(branches);
                withDistance.setDistance(Math.round(min.get()));
                return new ResponseEntity<BranchesWithDistance>(withDistance, HttpStatus.OK);
            }
        }

        return new ResponseEntity<ErrorResponse>(new ErrorResponse().status("branch not found"), HttpStatus.NOT_FOUND);
    }

}
