package com.alfa.battle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ATMFinderController {

    @RequestMapping("/find")
    public String findATM() {
        return "There is no ATM";
    }
}
