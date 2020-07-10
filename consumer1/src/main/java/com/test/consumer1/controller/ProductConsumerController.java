package com.test.consumer1.controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.test.consumer1.controller.dto.Manufacturer;
import com.test.consumer1.services1.ProductConsumerService;

@RestController
@RequestMapping("/myconsumer")
public class ProductConsumerController {

	@Autowired
	ProductConsumerService productConsumerService;

	@RequestMapping(method = RequestMethod.GET, path = "/manufacturers/name/{manufacturername}")
	public ResponseEntity<Manufacturer> getProdList(@PathVariable String manufacturername) throws IOException {
		System.out.println("Inside getproductlist(): start: " + manufacturername);
		return productConsumerService.getProductList(manufacturername).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

}
