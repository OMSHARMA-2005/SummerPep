package com.example.inventory.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.Product;
public interface ProductRepo extends JpaRepository<Product, Long>{
		
		Optional<Product> findByProductName(String productName);
}
