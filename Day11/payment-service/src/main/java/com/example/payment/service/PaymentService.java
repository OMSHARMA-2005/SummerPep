package com.example.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepo;

@Service
public class PaymentService {
	@Autowired
	RestTemplate restTemplate;
	
	public String processPayment(String product)
	{
		String stockStatus=restTemplate.getForObject("http://localhost:8083/inventory/check/"+product, String.class);
		if(stockStatus.equals("AVAILABLE"))
		{
			return "PAYMENT SUCCESS";
		}
		
		return "PAYMENT FAILED: PRODUCT OUT OF STOCK";
	}
	
	
	
	
//	@Autowired
//	private PaymentRepo repo;
//	
//	public Payment savePayment(Payment payment)
//	{
//		return repo.save(payment);
//	}
//	
//	public List<Payment> getAllPayments()
//	{
//		return repo.findAll();
//	}
//	
//	public Payment getPayementById(Long id)
//	{
//		return repo.findById(id).orElse(null);
//	}

}
