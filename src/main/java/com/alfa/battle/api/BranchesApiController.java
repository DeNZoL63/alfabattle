package com.alfa.battle.api;

import com.alfa.battle.model.Branches;
import com.alfa.battle.model.BranchesWithPredicting;
import com.alfa.battle.repository.BranchesRepo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-06-27T15:13:40.716+04:00")

@Controller
public class BranchesApiController implements BranchesApi {

    @Qualifier("branchesRepo")
    @Autowired
    private BranchesRepo branchesRepo;

    public ResponseEntity<Branches> getBranchUsingGET(
            @ApiParam(value = "id", required = true) @PathVariable("id") Long id
    ) {

        Branches branches = branchesRepo.findById(id).orElse(null);

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

    public ResponseEntity<Branches> getNearBranchUsingGET(@ApiParam(value = "lat", required = true) @RequestParam(value = "lat", required = true) Double lat,
                                                          @ApiParam(value = "lon", required = true) @RequestParam(value = "lon", required = true) Double lon
    ) {
        // do some magic!
        return new ResponseEntity<Branches>(HttpStatus.OK);
    }

}
