package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.Goat;
import com.codeup.barndoor.models.Herd;
import com.codeup.barndoor.repositories.HerdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HerdController {

    HerdRepository herdDao;

    @GetMapping("/herds")
    public String showHerds(Model model){
        List<Herd> herds = herdDao.findAll();
        model.addAttribute("herds", herds);
        return "herds/herds";
    }

    @GetMapping("/herd/{id}")
    public String showHerdPage(@PathVariable long id, Model model){
//         This will not work unless tables have data in them
         List<Goat> herd = herdDao.findById(id).getGoats();
         model.addAttribute("herd", herd);
        return "herds/herd";
    }
}
