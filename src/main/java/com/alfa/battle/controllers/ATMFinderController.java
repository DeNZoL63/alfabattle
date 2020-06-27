package com.alfa.battle.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ATMFinderController {

    @RequestMapping("/find")
    public String findATM() {
        return "There is no ATM";
    }
}
