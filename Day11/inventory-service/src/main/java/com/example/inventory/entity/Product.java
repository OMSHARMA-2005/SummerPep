package com.example.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String productName;
	private Integer quantity;
	public Product(Long id, String productName, Integer quantity) {

		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
	}
	
	
}
