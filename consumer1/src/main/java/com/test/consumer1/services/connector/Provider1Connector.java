package com.test.consumer1.services.connector;


import java.io.IOException;
import java.net.URI;
import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Provider1Connector {
	
	private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public Provider1Connector(String providerRootUri, RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder
                .rootUri(URI.create(providerRootUri).toString())
                .setConnectTimeout(Duration.ofMillis(1000))
                .setReadTimeout(Duration.ofMillis(2000))
                .build();
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<String> getData(String relativeUrl) {
        return restTemplate.getForEntity(relativeUrl, String.class);
    }

    public <T> T serializeData(String stringValue, Class<T> classSerialize) throws IOException {

        try {
            return objectMapper.readValue(stringValue, classSerialize);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;

    }}







