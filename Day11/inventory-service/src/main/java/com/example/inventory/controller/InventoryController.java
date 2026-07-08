package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.inventory.entity.Product;
import com.example.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService serv;
	
	@PostMapping
	public Product addProduct(@RequestBody Product product)
	{
		return serv.saveProduct(product);
	}
	
	@GetMapping
	public List<Product> getAll()
	{
		return serv.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getPById(@PathVariable Long id)
	{
		return serv.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,
            @RequestBody Product product) {
return serv.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id)
	{
		serv.deleteProduct(id);
		return "Product deleted";
	}
	
}
	
	


