package com.test.consumer1.services1;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.consumer1.controller.dto.Manufacturer;
import com.test.consumer1.services.connector.Provider1Connector;

@Service
public class ProductConsumerService {

	@Autowired
	private Provider1Connector providerConnector;

	public Optional<Manufacturer> getProductList(String manuname) throws IOException {
		System.out.println("ProductConsumerService: getProductList(): start : ");
		return Optional.ofNullable(providerConnector.serializeData(
				providerConnector.getData(String.format("/manufacturers/name/%s", manuname)).getBody(),
				Manufacturer.class));
	}

}
