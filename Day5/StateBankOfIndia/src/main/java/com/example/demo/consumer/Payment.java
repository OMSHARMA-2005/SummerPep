package com.example.demo.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class Payment {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public String getCartData() {
		
		//find CART-SERVICE instances from Eureka
		List<ServiceInstance>instances=discoveryClient.getInstances("PAYMENT-SERVICE");
		if(instances==null || instances.isEmpty())
		{
			return "PAYMENT SERVICE Not Available right now";
		}
		//pick first available instance
		ServiceInstance instance=instances.get(0);
		
		//Create URL to call CART_SERVICE
		String url= instance.getUri()+"/payment/data";
		
		//Call CART-SERVICE
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate.getForObject(url, String.class);

}
}
