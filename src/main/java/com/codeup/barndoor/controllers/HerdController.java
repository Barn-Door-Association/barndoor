package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.*;
import com.codeup.barndoor.repositories.GoatRepository;
import com.codeup.barndoor.repositories.HerdRepository;
import com.codeup.barndoor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class HerdController {

    @Value("${FILESTACK_API_KEY}")
    private String filestackKey;
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findById(user.getId());
        List<Herd> herds = herdDao.findByUserId(user.getId());
        model.addAttribute("herds", herds);
        model.addAttribute("user", currentUser);
        return "herds/herds";
    }

    @GetMapping("/herds/{id}")
    public String showHerdPage(@PathVariable long id, Model model){
         Herd herd = herdDao.findById(id);
         model.addAttribute("herd",  herd);
         model.addAttribute("filestackKey", filestackKey);
        return "herds/herd";
    }
    // Captures data from modal form post request, data is stored in a HerdRequest
    // object and then constructs a new Herd object with the entered values.  Then
    // the new Herd object data is stored in a table

    @ResponseBody
    @PostMapping("/add/new/herd")
    public String addNewHerd(@RequestBody HerdRequest herdRequest) {
        User user = userDao.findById(herdRequest.getUserId());
        Herd newHerd = new Herd(herdRequest.getHerdName(), herdRequest.getDescription(), user);
        herdDao.save(newHerd);
        return "";
    }

    @ResponseBody
    @PostMapping("/edit/herds/id")
    public String editHerd(@RequestBody HerdRequest herdRequest) {
        Herd editedHerd = herdDao.findById(herdRequest.getHerdId());
        editedHerd.setHerdName(herdRequest.getHerdName());
        editedHerd.setDescription(herdRequest.getDescription());
        herdDao.save(editedHerd);
        return "herds";
    }
}
