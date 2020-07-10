package com.test.consumer1.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.consumer1.services.connector.Provider1Connector;

@Configuration
public class MyConfig {

	@Value("${provider.rooturi}")
	String providerRootUri;

	@Bean
	public Provider1Connector getProviderConnector(@Autowired ObjectMapper objectMapper,
			@Autowired RestTemplateBuilder restTemplateBuilder) {
		return new Provider1Connector(providerRootUri, restTemplateBuilder, objectMapper);
	}

}
