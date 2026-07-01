package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@GetMapping("/getProduct")
	public String getPro() {
		return "Laptop= Rs.60006";
	}

}
