package com.example.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.entity.Payment;
import com.example.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	PaymentService serv;
	
	@GetMapping("/{product}")
	public String pay(@PathVariable String product)
	{
		return serv.processPayment(product);
	}
	
	
	
//	@Autowired
//	private PaymentService serv;
//	
//	@PostMapping
//	public Payment savePayment(@RequestBody Payment payment)
//	{
//		return serv.savePayment(payment);
//	}
//	
//	@GetMapping
//	public List<Payment> getAllPayments()
//	{
//		return serv.getAllPayments();
//	}
//	
//	@GetMapping("/{id}")
//	public Payment getPayment(@PathVariable Long id)
//	{
//		return  serv.getPayementById(id);
//	}
	
	
	

}
