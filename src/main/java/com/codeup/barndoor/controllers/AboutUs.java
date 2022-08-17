package com.codeup.barndoor.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUs {

    @GetMapping("/about")
    public String showAboutPage(){
        return "about-us";
    }
}
