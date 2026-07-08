package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.Product;
import com.example.inventory.repo.ProductRepo;

@Service
public class InventoryService {
	
	@Autowired
	private ProductRepo repo;
	
	public Product saveProduct(Product product)
	{
		return repo.save(product);
	}
	
	public List<Product> getAllProducts()
	{
		return repo.findAll();
	}

	public Product getProductById(Long id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public Product updateProduct(Long id, Product product)
	{
		Product exist=repo.findById(id).orElse(null);
		if(exist!=null)
		{
			exist.setProductName(product.getProductName());
			exist.setQuantity(product.getQuantity());
			return repo.save(exist);
		}
		return null;
	}
	
	public void deleteProduct(Long id)
	{
		repo.deleteById(id);
	}
	
	
	
	
	
}
