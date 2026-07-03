package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

	@GetMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("title", "Contact");
		model.addAttribute("message", "Email us at xyz@gmail.com");
		return "dashboard";
	}
}
