package com.alfa.battle.api;

import com.alfa.battle.model.AtmResponse;
import com.alfa.battle.model.ErrorResponse;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-06-27T15:23:34.047+04:00")

@Api(value = "atms", description = "the atms API")
public interface AtmsApi {

    @ApiOperation(value = "getById", notes = "", response = AtmResponse.class, tags={ "atm-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AtmResponse.class),
        @ApiResponse(code = 404, message = "NOT FOUND", response = AtmResponse.class) })
    @RequestMapping(value = "/atms/{id}",
        produces = { "*_/_*" }, 
        method = RequestMethod.GET)
    ResponseEntity<AtmResponse> getByIdUsingGET(
@ApiParam(value = "id",required=true ) @PathVariable("id") Integer id


);


    @ApiOperation(value = "getNearestAtm", notes = "", response = AtmResponse.class, tags={ "atm-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AtmResponse.class) })
    @RequestMapping(value = "/atms/nearest",
        produces = { "*_/_*" }, 
        method = RequestMethod.GET)
    ResponseEntity<AtmResponse> getNearestAtmUsingGET(@ApiParam(value = "latitude") @RequestParam(value = "latitude", required = false) String latitude



,@ApiParam(value = "longitude") @RequestParam(value = "longitude", required = false) String longitude



,@ApiParam(value = "payments", defaultValue = "false") @RequestParam(value = "payments", required = false, defaultValue="false") Boolean payments



);


    @ApiOperation(value = "getNearestAtmsWithMoney", notes = "", response = AtmResponse.class, responseContainer = "List", tags={ "atm-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AtmResponse.class) })
    @RequestMapping(value = "/atms/nearest-with-alfik",
        produces = { "*_/_*" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<AtmResponse>> getNearestAtmsWithMoneyUsingGET(@ApiParam(value = "alfik") @RequestParam(value = "alfik", required = false) Integer alfik



,@ApiParam(value = "latitude") @RequestParam(value = "latitude", required = false) String latitude



,@ApiParam(value = "longitude") @RequestParam(value = "longitude", required = false) String longitude



);

}
