package com.test.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRabbitMq2Application {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "bootapp");
		SpringApplication.run(SpringRabbitMq2Application.class, args);
	}
}
