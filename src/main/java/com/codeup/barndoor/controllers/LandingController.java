package com.codeup.barndoor.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping("/landing")
    public String showLandingPage(){
//        model.addAttribute("index", index);
        return "index";
    }
}
