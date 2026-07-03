package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        service.validate(username, password);

        session.setAttribute("user", username);

        model.addAttribute("username", username);

        return "home";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        model.addAttribute("username", session.getAttribute("user"));

        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }

}