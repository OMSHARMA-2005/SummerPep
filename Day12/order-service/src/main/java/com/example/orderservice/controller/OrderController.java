package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService serv;
	
	@GetMapping("/{product}")
	public String placeOrder(@PathVariable String product)
	{
		return serv.placeOrder(product);
	}
	
	
//	@Autowired
//	private OrderService service;
//	
//	@PostMapping
//	public Order saveOrder(@RequestBody Order order)
//	{
//		return service.saveOrder(order);
//	}

}
