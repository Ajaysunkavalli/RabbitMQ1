package com.tek.rabbitmq.controller;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tek.rabbitmq.model.Product;

@RestController
public class MessageController {
	@Autowired
	RestTemplate restTemplate;

	@RabbitListener(queues = "TekgroupProducts")
	public void listen(Message message) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Listener");
		System.out.println(message.getBody());
		byte[] p = message.getBody();
		String str = new String(p);
		System.out.println(str);

		// String to Object
		Product product = new ObjectMapper().readValue(str, Product.class);

		restTemplate.postForLocation("http://localhost:9090/save", product);

	}

}
