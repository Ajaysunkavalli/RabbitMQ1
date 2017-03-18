package com.tek.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRabbitMq1Application {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "bootapp");
		SpringApplication.run(SpringRabbitMq1Application.class, args);
	}
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
