package com.test.product1;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.test.provider1.EcommerceApplication;
import com.test.provider1.model.po.ManufacturerPO;
import com.test.provider1.model.po.ProductsPO;
import com.test.provider1.service.EcommerceService;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
@RunWith(PactRunner.class)
@Provider("ecommereceprovider")
@PactBroker
@VerificationReports(value = { "console", "markdown", "json" })
public class Product1BrokerTest {
	private int PORT = 9080;

	@TestTarget
	public final Target target = new HttpTarget("http", "localhost", PORT);
    private static ConfigurableApplicationContext applicationContext;

	@BeforeClass
	public static void setVersion() {
		System.setProperty("pact.provider.version", "1.0.0");
		System.setProperty("pact.verifier.publishResults", "true");
	}

	@BeforeClass
	public static void start() {
		applicationContext = SpringApplication.run(EcommerceApplication.class);
	}

	@AfterClass
    public static void stop() {
		SpringApplication.exit(applicationContext);
	}

	@State("SomeState")
	public void WithStateNewProduct() {
		System.out.println("something with state");
		EcommerceService ecommerceservice = applicationContext.getBean(EcommerceService.class);
		ecommerceservice.addManufacturer(new ManufacturerPO("502", "Xiaomi", "India", null));
		ecommerceservice.addProduct(new ProductsPO("104", "Redmi", "Mobile", 10000.0, "502"));
	}
}