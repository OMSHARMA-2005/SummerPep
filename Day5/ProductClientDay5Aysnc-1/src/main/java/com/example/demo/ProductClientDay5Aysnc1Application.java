package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;


@EnableAsync
@SpringBootApplication
public class ProductClientDay5Aysnc1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductClientDay5Aysnc1Application.class, args);
	}
	
	@Bean
	public RestTemplate restTempalate() {
		return new RestTemplate();
	}
	

}
