package com.codeup.barndoor.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Value("${FILESTACK_API_KEY}")
    private String filestackKey;

    @GetMapping("/filestack")
    public String filestackTest (Model model) {
        model.addAttribute("filestackKey", filestackKey);
        return "goats/filestack-test";
    }

}
