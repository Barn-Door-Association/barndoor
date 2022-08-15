package com.codeup.barndoor.controllers;


import com.codeup.barndoor.models.User;
import org.hibernate.mapping.Index;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class landingController {

    @GetMapping("/landing")
    public String showLandingPage(){
//        model.addAttribute("index", index);
        return "index";
    }
}
