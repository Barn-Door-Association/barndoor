package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.Goat;
import com.codeup.barndoor.models.GoatRequest;
import com.codeup.barndoor.models.Herd;
import com.codeup.barndoor.repositories.GoatRepository;
import com.codeup.barndoor.repositories.HerdRepository;
import com.codeup.barndoor.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class HerdController {

    private final HerdRepository herdDao;
    private final GoatRepository goatDao;

    private final UserRepository userDao;

    public HerdController(HerdRepository herdDao, GoatRepository goatDao, UserRepository userDao){
        this.herdDao = herdDao;
        this.goatDao = goatDao;
        this.userDao = userDao;
    }

    @GetMapping("/herds")
    public String showHerds(Model model){
        List<Herd> herds = herdDao.findAll();
        model.addAttribute("herds", herds);
        model.addAttribute("user", userDao.findById(1).getRanchName());
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
