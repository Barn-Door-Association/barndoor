package com.codeup.barndoor.controllers;

import com.codeup.barndoor.repositories.GoatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GoatController {

    private final GoatRepository goatDao;

    public GoatController(GoatRepository goatDao){
        this.goatDao = goatDao;
    }

    @GetMapping("/goat/{id}")
    public String showGoatInfo(@PathVariable long id, Model model){
        model.addAttribute("goat", goatDao.findById(id));
        return "goats/goat";
    }
}
