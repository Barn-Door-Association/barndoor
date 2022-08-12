package com.codeup.barndoor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HerdController {

    @GetMapping("/herd")
    public String showHerdPage(){
        return "herd";
    }
}
