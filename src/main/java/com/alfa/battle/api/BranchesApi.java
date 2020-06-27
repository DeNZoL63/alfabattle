package com.alfa.battle.api;

import com.alfa.battle.model.Branches;
import com.alfa.battle.model.ErrorResponse;
import com.alfa.battle.model.BranchesWithPredicting;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-06-27T15:13:40.716+04:00")

@Api(value = "branches", description = "the branches API")
public interface BranchesApi {

    @ApiOperation(value = "getBranch", notes = "", response = Branches.class, tags={ "branches-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Branches.class),
        @ApiResponse(code = 404, message = "NOT FOUND", response = Branches.class) })
    @RequestMapping(value = "/branches/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Branches> getBranchUsingGET(
@ApiParam(value = "id",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "getBranchesWithPredicting", notes = "", response = BranchesWithPredicting.class, tags={ "predict-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BranchesWithPredicting.class),
        @ApiResponse(code = 404, message = "NOT FOUND", response = BranchesWithPredicting.class) })
    @RequestMapping(value = "/branches/{id}/predict",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<BranchesWithPredicting> getBranchesWithPredictingUsingGET(@ApiParam(value = "dayOgWeek", required = true) @RequestParam(value = "dayOgWeek", required = true) Integer dayOgWeek



,@ApiParam(value = "hourOfDay", required = true) @RequestParam(value = "hourOfDay", required = true) Integer hourOfDay



,
@ApiParam(value = "id",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "getNearBranch", notes = "", response = Branches.class, tags={ "branches-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Branches.class) })
    @RequestMapping(value = "/branches",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Branches> getNearBranchUsingGET(@ApiParam(value = "lat", required = true) @RequestParam(value = "lat", required = true) Double lat



,@ApiParam(value = "lon", required = true) @RequestParam(value = "lon", required = true) Double lon



);

}
