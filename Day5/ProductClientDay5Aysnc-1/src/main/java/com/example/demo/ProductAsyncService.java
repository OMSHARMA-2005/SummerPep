package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductAsyncService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Async
	public void fetchProduct()
	{
		String response= restTemplate.getForObject("http://localhost:8081/product", String.class);
		System.out.println(response);
	}
}
