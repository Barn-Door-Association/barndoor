package com.codeup.barndoor.controllers;

import com.codeup.barndoor.models.User;
import com.codeup.barndoor.models.UserRequest;
import com.codeup.barndoor.repositories.UserRepository;
import com.codeup.barndoor.util.Password;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, Errors validation, Model model) {
        List<String> errorMsg = new ArrayList<>();

//  If username is already in the database
        if (userDao.findByUsername(user.getUsername()) != null) {
            validation.rejectValue("username", "*Username already exists");
            errorMsg.add("*Username already exists");
        }

//  If user email is already in database
        if (userDao.findByEmail(user.getEmail()) != null) {
            validation.rejectValue("email", "*This email is already used");
            errorMsg.add("*This email is already used");
        }

//  If the Ranch Name is already in database
        if (userDao.findByRanchName(user.getRanchName()) != null) {
            validation.rejectValue("RanchName", "*This Ranch Name already exists");
            errorMsg.add("*This Ranch Name already exists");
        }
//  If any fields are left blank
        if (user.getUsername().isEmpty() || user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty() || user.getRanchName().isEmpty()) {
            validation.rejectValue("RanchName", "*You must provide a Ranch Name");
            errorMsg.add("*All fields must be filled out");
        }
//  Validates if Password meets criteria
        if (!Password.isValid(user.getPassword())) {
            validation.rejectValue(
                    "password",
                    "Invalid Password",
                    "Password must be 8 or more characters, contain at least one upper and lowercase letter, a number and a symbol."
            );
            errorMsg.add("*This is an invalid password");
        }
//  Consolidates
        if (validation.hasErrors()) {
            model.addAttribute("errorList", errorMsg);
            model.addAttribute("user", user);
            return "users/register";
        }


//  Hashes Password
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login-page";
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "users/profile";
    }

    @ResponseBody
    @PostMapping("/profile/edit")
    public String editProfilePage(@RequestBody UserRequest userRequest) {
        User editedUser = userDao.findById(userRequest.getId());
        System.out.println(editedUser.getUsername());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setRanchName(userRequest.getRanchName());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        editedUser.setRanchName(userRequest.getRanchName());
        editedUser.setFirstName(userRequest.getFirstName());
        editedUser.setLastName(userRequest.getLastName());
        editedUser.setEmail(userRequest.getEmail());
        userDao.save(editedUser);
        return "users/profile";
    }
}