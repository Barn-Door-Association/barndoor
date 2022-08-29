package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.*;
import com.codeup.barndoor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ObjectInputFilter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class GoatController {

    private final GoatRepository goatDao;
    private final HerdRepository herdDao;
    private final VaccineRecordRepository vaccineRecordDao;
    private final VaccineRepository vaccineDao;

    public GoatController(GoatRepository goatDao, HerdRepository herdDao, VaccineRecordRepository vaccineRecordDao, VaccineRepository vaccineDao) {
        this.goatDao = goatDao;
        this.herdDao = herdDao;
        this.vaccineRecordDao = vaccineRecordDao;
        this.vaccineDao = vaccineDao;
    }

    @GetMapping("/goat/{id}")
    public String showGoatInfo(@PathVariable long id, Model model) {
        // Add method to fix the date format to yyyy-mm-dd before displaying through the model
        Goat goat = goatDao.findById(id);
        String date = goat.getDob().toString().substring(0, 10);
        List<Vaccine> vaccines = vaccineDao.findAll();
        model.addAttribute("vaccines", vaccines);
        model.addAttribute("dob", date);
        model.addAttribute("goat", goat);
        model.addAttribute("records", goatDao.findById(id).getRecords());
        return "goats/goat";
    }

    // Captures data from modal form post request, data is stored in a GoatRequest
    // object and then constructs a new Goat object with the entered values.  Then
    // the new Goat object data is stored in a table
    @ResponseBody
    @PostMapping("/add/new/goat")
    public String addNewGoat(@RequestBody GoatRequest goatRequest) {
        if (goatRequest.getImg() == null || goatRequest.getImg().equals("")) {
            goatRequest.setImg("/img/defaultgoat.jpg");
        }
        Goat newGoat = new Goat(
                goatRequest.getTagId(),
                goatRequest.getName(),
                goatRequest.getDob(),
                goatRequest.getSex(),
                goatRequest.getBreed(),
                goatRequest.getWeightInPounds(),
                goatRequest.getImg(),
                herdDao.findById(goatRequest.getHerdId())
        );
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
    public String showPedigree(@PathVariable long id, Model model) {
        Goat goat = goatDao.findById(id);
        model.addAttribute("goat", goat);
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

    @ResponseBody
    @PostMapping("/add/vaccine/{id}")
    public String addVaccine(@RequestBody VaccineAddRequest vaccineAddRequest) {
        System.out.println(vaccineAddRequest.getVaccineId());
        System.out.println(vaccineAddRequest.getGoatId());
        System.out.println(vaccineAddRequest.getDateAdministered());
        System.out.println(vaccineAddRequest.getDosageInCcs());
        System.out.println(vaccineAddRequest.getIsBooster());
        Goat goat = goatDao.findById((vaccineAddRequest.getGoatId()));
        Vaccine vaccine = vaccineDao.findById(vaccineAddRequest.getVaccineId()).get();
        VaccineRecord vaccineRecord = new VaccineRecord(
                vaccineAddRequest.getDosageInCcs(),
                vaccineAddRequest.getDateAdministered(),
                vaccineAddRequest.getIsBooster(),
                vaccine,
                goat
        );
        vaccineRecordDao.save(vaccineRecord);
        return "goat";
    }
}