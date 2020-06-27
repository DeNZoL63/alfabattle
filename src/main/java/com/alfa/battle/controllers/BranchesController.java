package com.alfa.battle.controllers;

import com.alfa.battle.api.BranchesApiController;
import com.alfa.battle.model.Branches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BranchesController {

    @Autowired
    private BranchesApiController branchesApiController;

    @RequestMapping(
            value = "/branches/{id}",
            method = RequestMethod.GET
    )
    @ResponseBody
    public ResponseEntity<Branches> getBranchesById(@PathVariable("id") Long id) {
        return branchesApiController.getBranchUsingGET(id);
    }
}
