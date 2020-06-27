package com.alfa.battle.api;

import com.alfa.battle.model.AtmResponse;
import com.alfa.battle.model.ErrorResponse;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-06-27T15:23:34.047+04:00")

@Controller
public class AtmsApiController implements AtmsApi {

    public ResponseEntity<AtmResponse> getByIdUsingGET(
@ApiParam(value = "id",required=true ) @PathVariable("id") Integer id


) {
        // do some magic!
        return new ResponseEntity<AtmResponse>(HttpStatus.OK);
    }

    public ResponseEntity<AtmResponse> getNearestAtmUsingGET(@ApiParam(value = "latitude") @RequestParam(value = "latitude", required = false) String latitude



,
        @ApiParam(value = "longitude") @RequestParam(value = "longitude", required = false) String longitude



,
        @ApiParam(value = "payments", defaultValue = "false") @RequestParam(value = "payments", required = false, defaultValue="false") Boolean payments



) {
        // do some magic!
        return new ResponseEntity<AtmResponse>(HttpStatus.OK);
    }

    public ResponseEntity<List<AtmResponse>> getNearestAtmsWithMoneyUsingGET(@ApiParam(value = "alfik") @RequestParam(value = "alfik", required = false) Integer alfik



,
        @ApiParam(value = "latitude") @RequestParam(value = "latitude", required = false) String latitude



,
        @ApiParam(value = "longitude") @RequestParam(value = "longitude", required = false) String longitude



) {
        // do some magic!
        return new ResponseEntity<List<AtmResponse>>(HttpStatus.OK);
    }

}
