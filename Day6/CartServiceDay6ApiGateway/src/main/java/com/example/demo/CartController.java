package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
	@GetMapping("/cart")
	public String cart()
	{
		return "Cart SErvice: 2 items";
	}
}
