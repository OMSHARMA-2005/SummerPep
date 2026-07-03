package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService service;

    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {

            model.addAttribute("error", "Password and Confirm Password must match");

            return "register";
        }

        String message = service.register(user);

        if (message.equals("Username already exists")) {

            model.addAttribute("error", message);

            return "register";
        }

        model.addAttribute("message", message);

        return "registerSuccess";
    }
}