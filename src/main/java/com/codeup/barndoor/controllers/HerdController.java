package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.Goat;
import com.codeup.barndoor.models.GoatRequest;
import com.codeup.barndoor.models.Herd;
import com.codeup.barndoor.models.HerdRequest;
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
    // Captures data from modal form post request, data is stored in a HerdRequest
    // object and then constructs a new Herd object with the entered values.  Then
    // the new Herd object data is stored in a table
    @ResponseBody
    @PostMapping("/add/new/herd")
    public String addNewHerd(@RequestBody HerdRequest herdRequest) {
        Herd newHerd = new Herd(herdRequest.getHerd_name(), herdRequest.getDescription(), herdDao.findById(herdRequest.getUserid()));
        herdDao.save(newHerd);
        return "New Herd";
    }

    @ResponseBody
    @PostMapping("/edit/herds/id")
    public String editHerd(@RequestBody HerdRequest herdRequest) {
        Herd editedHerd = herdDao.findById(herdRequest.getHerd_id());
        editedHerd.setHerdName(herdRequest.getHerd_name());
        editedHerd.setDescription(herdRequest.getDescription());
        herdDao.save(editedHerd);
        return "herds";
    }
}
