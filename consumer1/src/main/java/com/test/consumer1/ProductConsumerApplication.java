package com.test.consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ProductConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductConsumerApplication.class, args);

	}
}
