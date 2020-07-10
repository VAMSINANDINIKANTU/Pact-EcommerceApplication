package com.test.provider1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.provider1.model.po.ManufacturerPO;
import com.test.provider1.model.po.ProductsPO;
import com.test.provider1.model.vo.ManufacturerVO;
import com.test.provider1.repository.ManufacturerRepository;
import com.test.provider1.repository.ProductsRepository;

@SpringBootApplication
public class EcommerceApplication {

	@GetMapping("keepAlive")
	public ResponseEntity<String> keepAlive() {
		return ResponseEntity.ok("Keep_alive");
	}

	public static void main(String[] args) {

		SpringApplication.run(EcommerceApplication.class, args);
	}

}
