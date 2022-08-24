package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.*;
import com.codeup.barndoor.repositories.GoatRepository;
import com.codeup.barndoor.repositories.HerdRepository;
import com.codeup.barndoor.repositories.VaccineRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@Controller
public class GoatController {

    @Autowired
    private final GoatRepository goatDao;
    private final HerdRepository herdDao;

    private final VaccineRecordRepository vaccineRecordDao;


    public GoatController(GoatRepository goatDao, HerdRepository herdDao, VaccineRecordRepository vaccineRecordDao) {
        this.goatDao = goatDao;
        this.herdDao = herdDao;
        this.vaccineRecordDao = vaccineRecordDao;
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
        Goat goat = goatDao.findById(id);
        return goat;
    }

    @GetMapping("/goats/{id}/pedigree")
    public String showPedigree(@PathVariable long id) {
        return "goats/pedigree";
    }


    // controller for edit goat feature
    // testing functionality
//    @GetMapping
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
    @ResponseBody
    @PostMapping("/edit/vaccine/id")
    public String editVaccine(@RequestBody VaccineRecord vaccineRecord) {
        VaccineRecord editedVaccine = vaccineRecordDao.findById(vaccineRecord.getId());
        editedVaccine.setDosageInCcs(vaccineRecord.getDosageInCcs());
        editedVaccine.setDateAdministered(vaccineRecord.getDateAdministered());
//        editedVaccine.setBooster(vaccineRecord.get());
        editedVaccine.setVaccine(vaccineRecord.getVaccine());
        vaccineRecordDao.save(editedVaccine);
        return "goat";
    }

}