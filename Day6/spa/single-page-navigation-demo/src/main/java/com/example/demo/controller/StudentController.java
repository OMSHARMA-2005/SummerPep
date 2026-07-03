package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//name, course , sem, college

@Controller
public class StudentController {

	@GetMapping("/student")
	public String student(Model model)
	{
		model.addAttribute("Name","Anish");
		model.addAttribute("Course","B.Tech CSE");
		model.addAttribute("Semester","6th");
		model.addAttribute("College","LPU");
		return "dashboard";
		
	}
}
