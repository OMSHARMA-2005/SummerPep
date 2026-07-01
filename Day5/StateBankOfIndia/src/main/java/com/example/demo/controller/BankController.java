package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.consumer.Payment;

@RestController
public class BankController {

	@Autowired
	private Payment p;
	
	@GetMapping("/bank/data")
	public String getBankData()
	{
		return "From BANK-SERVICE: "+p.getCartData();
	}
}
