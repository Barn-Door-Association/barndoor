package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.EditGoatRequest;
import com.codeup.barndoor.models.Goat;
import com.codeup.barndoor.models.GoatRequest;
import com.codeup.barndoor.repositories.GoatRepository;
import com.codeup.barndoor.repositories.HerdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
        Goat sire = goatDao.findByName(goatRequest.getSireName());
        Goat dam = goatDao.findByName(goatRequest.getDamName());
        Set<Goat> parents = new HashSet<>();
        parents.add(sire);
        parents.add(dam);
        newGoat.setParents(parents);
        goatDao.save(newGoat);
        return "yo";
    }

    @GetMapping("/pedigree/{id}")
    @ResponseBody
    public Goat getPedigree(@PathVariable long id) {
        return goatDao.findById(id);
    }

    @GetMapping("/goats/{id}/pedigree")
    public String showPedigree(@PathVariable long id) {
        return "goats/pedigree";
    }

    // controller for edit goat feature
    @ResponseBody
    @PostMapping("/edit/goat")
    public String editGoat(@RequestBody EditGoatRequest editGoatRequest) {
        Goat goat = goatDao.findById(editGoatRequest.getGoatId());
        Goat editedGoat = goatDao.findById(editGoatRequest.getGoatId());
        goat.setName(editGoatRequest.getName());
        goat.setTagId(editGoatRequest.getTagId());
        goat.setBreed(editGoatRequest.getBreed());
        goat.setSex(editGoatRequest.getSex());
        goat.setDob(editGoatRequest.getDob());
        goat.setWeightInPounds(editGoatRequest.getWeightInPounds());

        editedGoat.setName(editGoatRequest.getName());
        editedGoat.setTagId(editGoatRequest.getTagId());
        editedGoat.setBreed(editGoatRequest.getBreed());
        editedGoat.setSex(editGoatRequest.getSex());
        editedGoat.setDob(editGoatRequest.getDob());
        editedGoat.setWeightInPounds(editGoatRequest.getWeightInPounds());

        goatDao.save(editedGoat);
        return "goat";
    }
}