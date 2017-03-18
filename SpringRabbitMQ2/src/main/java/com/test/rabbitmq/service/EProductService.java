package com.test.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rabbitmq.model.EProduct;
import com.test.rabbitmq.repository.EProductRepository;

@Service
public class EProductService {
	@Autowired
	EProductRepository eProductRepo;
	
	public void saveProduct(EProduct eProduct){
		eProductRepo.save(eProduct);
	}
	

}
