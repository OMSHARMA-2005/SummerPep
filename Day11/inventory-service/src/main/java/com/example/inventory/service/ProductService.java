package com.example.inventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.Product;
import com.example.inventory.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
	public String checkStock(String productName)
	{
		Optional<Product> product=repo.findByProductName(productName);
		if(product.isPresent() && product.get().getQuantity()>0)
		{
			
			return "AVAILABLE";	
		}
		
		return "Out of Stock";
		
	}

}
