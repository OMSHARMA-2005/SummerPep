package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
		private final KafkaProducerService producer;
		public KafkaController(KafkaProducerService producer)
		{
			this.producer=producer;
		}
		@GetMapping("/send/{message}")
		public String send(@PathVariable String message)
		{
			producer.sendMessage(message);
			return "Message Sent Successfully";
		}
}
