package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	@KafkaListener(topics="orderss", groupId="myGroup")
	public void consume(String message)
	{
		System.out.println("Consumer Recieved: "+message);
	}
}
