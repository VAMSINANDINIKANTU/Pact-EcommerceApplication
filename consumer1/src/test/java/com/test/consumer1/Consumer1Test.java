package com.test.consumer1;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.consumer1.services.connector.Provider1Connector;
import com.test.consumer1.services1.ProductConsumerService;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyTestConfig.class)
public class Consumer1Test {
	@Rule
	public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("ecommereceprovider", "localhost", 8066, this);

	@Autowired
	private ProductConsumerService consumerService;

	@Pact(consumer = "myconsumerPact") // will default to the provider name from
	// mockProvider in Rule
	public RequestResponsePact defineExpectation(PactDslWithProvider builder) {
		return builder.uponReceiving("get product list by Apple").path("/app/manufacturers/name/Apple").method("GET")
				.willRespondWith().status(200)
				.body("{\n" + "    \"manufacturerVOs\": [\n" + "        {\n"
						+ "            \"manufacturerId\": \"500\",\n"
						+ "            \"manufacturerName\": \"Apple\",\n"
						+ "            \"manufacturerAddress\": \"US\",\n" + "            \"productsList\": [\n"
						+ "                {\n" + "                    \"productId\": \"100\",\n"
						+ "                    \"productName\": \"iphone\",\n"
						+ "                    \"productType\": \"Mobile\",\n"
						+ "                    \"price\": 30000.0\n" + "                },\n" + "                {\n"
						+ "                    \"productId\": \"101\",\n"
						+ "                    \"productName\": \"iphone11 Pro\",\n"
						+ "                    \"productType\": \"Mobile\",\n"
						+ "                    \"price\": 15000.0\n" + "                }\n" + "            ]\n"
						+ "        }\n" + "    ]\n" + "}")
				.toPact();

	}

	@Pact(consumer = "myconsumerpact") // will default to the provider name from mockProvider in Rule
	public RequestResponsePact defineExpectationWithState(PactDslWithProvider builder) {

		return builder.uponReceiving("get product list by Samsung").path("/app/manufacturers/name/Samsung")
				.method("GET").willRespondWith().status(200)
				.body("{\n" + "    \"manufacturerVOs\": [\n" + "        {\n"
						+ "            \"manufacturerId\": \"501\",\n"
						+ "            \"manufacturerName\": \"Samsung\",\n"
						+ "            \"manufacturerAddress\": \"India\",\n" + "            \"productsList\": [\n"
						+ "                {\n" + "                    \"productId\": \"102\",\n"
						+ "                    \"productName\": \"Samsung\",\n"
						+ "                    \"productType\": \"Mobile\",\n"
						+ "                    \"price\": 17000.0\n" + "                }\n" + "            ]\n"
						+ "        }\n" + "    ]\n" + "}")

				.toPact();

	}

	@Pact(consumer = "myconsumerpact") // will default to the provider name from mockProvider in Rule

	public RequestResponsePact defineExpectationWithStateNewManfacturer(PactDslWithProvider builder) {

		return builder.given("SomeState").uponReceiving("get product list by Xiaomi")
				.path("/app/manufacturers/name/Xiaomi").method("GET").willRespondWith().status(200)
				.body("{\n" + "    \"manufacturerVOs\": [\n" + "        {\n"
						+ "            \"manufacturerId\": \"502\",\n"
						+ "            \"manufacturerName\": \"Xiaomi\",\n"
						+ "            \"manufacturerAddress\": \"India\",\n" + "            \"productsList\": [\n"
						+ "                {\n" + "                    \"productId\": \"104\",\n"
						+ "                    \"productName\": \"Redmi\",\n"
						+ "                    \"productType\": \"Mobile\",\n"
						+ "                    \"price\": 10000.0\n" + "                }\n" + "            ]\n"
						+ "        }\n" + "    ]\n" + "}")

				.toPact();
	}

	@Pact(consumer = "myconsumerpact") // will default to the provider name from mockProvider in Rule
	public RequestResponsePact defineExpectationProduct(PactDslWithProvider builder) {
		return builder.uponReceiving("get product list by productid 102").path("/app/products/102").method("GET")
				.willRespondWith().status(200)
				.body("{\n" + " \"productsVOs\": [\n" + " {\n" + " \"productId\": \"102\",\n"
						+ "   \"productName\": \"Samsung\",\n" + "  \"productType\": \"Mobile\",\n"
						+ "    \"price\":  17000.0 ,\n" + "     \"manufacturerId\": \"501\",\n"
						+ "   \"manufacturerName\": \"Samsung\",\n" + "  \"manufacturerAddress\": \"India\"\n" + "  }\n"
						+ "  ]\n" + "}")
				.toPact();
	}
	@Pact(consumer = "myconsumerpact") // will default to the provider name from mockProvider in Rule
	public RequestResponsePact defineExpectationWithStateNewProduct(PactDslWithProvider builder) {
		return builder.given("Oppo").uponReceiving("get product list by productid 105").path("/app/products/105").method("GET")
				.willRespondWith().status(200)
				.body("{\n" + " \"productsVOs\": [\n" + " {\n" + " \"productId\": \"105\",\n"
						+ "   \"productName\": \"Oppo Reno Pro\",\n" + "  \"productType\": \"Mobile\",\n"
						+ "    \"price\":  14000.0 ,\n" + "     \"manufacturerId\": \"504\",\n"
						+ "   \"manufacturerName\": \"Oppo\",\n" + "  \"manufacturerAddress\": \"Uk\"\n" + "  }\n"
						+ "  ]\n" + "}")
				.toPact();
	}
	

	@Test
	@PactVerification(fragment = "defineExpectation")
	public void test() throws IOException {
		Assert.assertTrue(consumerService.getProductList("Apple").isPresent());
	}

	@Test
	@PactVerification(fragment = "defineExpectationWithState")
	public void runTestWithState() throws IOException {
		Assert.assertTrue(consumerService.getProductList("Samsung").isPresent());

	}

	@Test
	@PactVerification(fragment = "defineExpectationWithStateNewManfacturer")
	public void runTestWithStateNewManfacturer() throws IOException {
		Assert.assertTrue(consumerService.getProductList("Xiaomi").isPresent());
	}

	@Test
	@PactVerification(fragment = "defineExpectationProduct")
	public void runTestStatewithProduct() throws IOException {
		Assert.assertTrue(consumerService.getProductListById("102").isPresent());
	}
	
	@Test
	@PactVerification(fragment = "defineExpectationWithStateNewProduct")
	public void runTestStatewithNewProduct() throws IOException {
		Assert.assertTrue(consumerService.getProductListById("105").isPresent());
	}
	
}

@TestConfiguration
class MyTestConfig {

	@Bean
	public ProductConsumerService getStudentConsumerService() {
		return new ProductConsumerService();
	}

	@Bean
	public Provider1Connector getProviderConnector(ObjectMapper objectMapper, RestTemplateBuilder restTemplateBuilder) {
		return new Provider1Connector("http://localhost:8066/app", restTemplateBuilder, objectMapper);
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public RestTemplateBuilder getRestTemplateBuilder() {
		return new RestTemplateBuilder();
	}
}