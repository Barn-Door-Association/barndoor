package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.Goat;
import com.codeup.barndoor.models.Herd;
import com.codeup.barndoor.repositories.GoatRepository;
import com.codeup.barndoor.repositories.HerdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HerdController {

    private final HerdRepository herdDao;
    private final GoatRepository goatDao;

    public HerdController(HerdRepository herdDao, GoatRepository goatDao){
        this.herdDao = herdDao;
        this.goatDao = goatDao;
    }

    @GetMapping("/herds")
    public String showHerds(Model model){
        List<Herd> herds = herdDao.findAll();
        model.addAttribute("herds", herds);
        return "herds/herds";
    }

    @GetMapping("/herds/{id}")
    public String showHerdPage(@PathVariable long id, Model model){
         List<Goat> herd = goatDao.findAllByHerdId(id);
         model.addAttribute("herd_id", id);
         model.addAttribute("herd_name", "Details for: " + herdDao.findById(id).getHerdName());
         model.addAttribute("herd",  herd);
        return "herds/herd";
    }
}
