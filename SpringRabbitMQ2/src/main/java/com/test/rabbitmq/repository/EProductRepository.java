package com.test.rabbitmq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.rabbitmq.model.EProduct;

public interface EProductRepository extends MongoRepository<EProduct, String> {

}
