package com.example.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.service.ProductService;

@RestController
@RequestMapping("/inventory")
public class ProductController {
	
	@Autowired
	ProductService serv;
	@GetMapping("/check/{name}")
	public String checkStock(@PathVariable String name)
	{
		return serv.checkStock(name);
	}
}
