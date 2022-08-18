package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.Goat;
import com.codeup.barndoor.models.GoatRequest;
import com.codeup.barndoor.repositories.GoatRepository;
import com.codeup.barndoor.repositories.HerdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class GoatController {

    @Autowired
    private final GoatRepository goatDao;
    private final HerdRepository herdDao;


    public GoatController(GoatRepository goatDao, HerdRepository herdDao) {
        this.goatDao = goatDao;
        this.herdDao = herdDao;
    }

    @GetMapping("/goat/{id}")
    public String showGoatInfo(@PathVariable long id, Model model) {
        model.addAttribute("goat", goatDao.findById(id));
        model.addAttribute("records", goatDao.findById(id).getRecords());
        return "goats/goat";
    }

    // Captures data from modal form post request, data is stored in a GoatRequest
    // object and then constructs a new Goat object with the entered values.  Then
    // the new Goat object data is stored in a table
    @ResponseBody
    @PostMapping("/add/new/goat")
    public String addNewGoat(@RequestBody GoatRequest goatRequest) {
        Goat newGoat = new Goat(goatRequest.getTagId(), goatRequest.getName(), goatRequest.getDob(), goatRequest.getSex(), goatRequest.getBreed(), goatRequest.getWeightInPounds(), herdDao.findById(goatRequest.getHerdId()));
        goatDao.save(newGoat);
        return "yo";
    }

    @GetMapping("/pedigree/{id}")
    @ResponseBody
    public Goat getPedigree(@PathVariable long id) {
        Goat goat = goatDao.findById(id);
        return goat;
    }

    @GetMapping("/goats/{id}/pedigree")
    public String showPedigree(Model model) {
        return "pedigree";
    }
}