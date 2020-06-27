package com.alfa.battle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ATMFinderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/showAll")
    public String findATM() {
        return restTemplate.getForEntity("https://apiws.alfabank.ru/alfabank/alfadevportal/atm-service/atms/status", String.class).getBody();
    }
}
