package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Visit /welcome";
    }

    @GetMapping("/welcome")
    public String welcome(@AuthenticationPrincipal OAuth2User user) {

        String name = user.getAttribute("name");
        String email = user.getAttribute("email");

        return """
                Welcome %s
                Email : %s

                Logout:
                http://localhost:8080/logout
                """.formatted(name, email);
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "You have logged out successfully.";
    }

}