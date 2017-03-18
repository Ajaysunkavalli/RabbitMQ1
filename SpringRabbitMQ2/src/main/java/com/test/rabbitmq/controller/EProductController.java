package com.test.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rabbitmq.model.EProduct;
import com.test.rabbitmq.service.EProductService;

@RestController
public class EProductController {
	
	@Autowired
	EProductService eProductService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public void saveProduct(@RequestBody EProduct eProduct){
		eProductService.saveProduct(eProduct);
		
	}

}
