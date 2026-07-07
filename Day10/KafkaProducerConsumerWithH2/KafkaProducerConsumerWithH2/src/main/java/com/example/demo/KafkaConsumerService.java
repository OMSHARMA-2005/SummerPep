package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Message;
import com.example.demo.repo.MessageRepository;


@Service
public class KafkaConsumerService {

	 private final MessageRepository repository;

	    public KafkaConsumerService(MessageRepository repository) {
	        this.repository = repository;
	    }

	    @KafkaListener(topics = "orderss", groupId = "myGroup")
	    public void consume(String message) {

	        System.out.println("Received : " + message);

	        Message msg = new Message(message);

	        repository.save(msg);

	        System.out.println("Saved into H2");
	    }
	}
