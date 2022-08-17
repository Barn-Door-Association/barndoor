package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.Goat;
import com.codeup.barndoor.models.GoatRequest;
import com.codeup.barndoor.models.Vaccine;
import com.codeup.barndoor.models.VaccineRecord;
import com.codeup.barndoor.repositories.GoatRepository;
import com.codeup.barndoor.repositories.HerdRepository;
import com.codeup.barndoor.repositories.VaccineRecordRepository;
import com.codeup.barndoor.repositories.VaccineRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
}