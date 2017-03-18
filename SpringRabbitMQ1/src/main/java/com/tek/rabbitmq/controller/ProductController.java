package com.tek.rabbitmq.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tek.rabbitmq.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/v1/tek")
@Api(value="For Queue")
//, description="Sending message to Queue")
public class ProductController {
	private static final String SIMPLE_QUEUE = "TekgroupProducts";

	@Autowired
	RabbitTemplate rabbitTemplate;

	@ApiOperation(value = "Sending message")
//	, response = List.class
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public void processProduct(@RequestBody Product prod)
			throws JsonGenerationException, JsonMappingException, IOException {
		// To convert Object to json
		ObjectMapper  mapper = new ObjectMapper();
		System.out.println(prod);

		String jsonInString = mapper.writeValueAsString(prod);
		System.out.println("Converted:" + jsonInString);
		rabbitTemplate.convertAndSend(SIMPLE_QUEUE, jsonInString);

	}
}
