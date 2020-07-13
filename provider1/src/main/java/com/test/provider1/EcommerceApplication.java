package com.test.provider1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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