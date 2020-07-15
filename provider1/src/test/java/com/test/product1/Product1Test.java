package com.test.product1;

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
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@PactFolder("C:\\Users\\win10\\Desktop\\New-Pact-master\\New-Pact-master\\consumer1\\target\\pacts")
@Provider("ecommereceprovider")
@VerificationReports(value = { "console", "markdown", "json" })
public class Product1Test {
	private int PORT = 9080;

	@TestTarget
	public final Target target = new HttpTarget("http", "localhost", PORT);
	private static ConfigurableApplicationContext applicationContext;

	@BeforeClass
	public static void setVersions() {
		System.setProperty("pact.provider.version", "1.0.0");
		System.setProperty("pact.verifier.publishResults", "true");
	}

	@BeforeClass
	public static void start() {
		applicationContext = SpringApplication.run(EcommerceApplication.class);
	}

	@State("SomeState")
	public void WithStateNewProduct() {
		System.out.println("something with state");
		EcommerceService ecommerceservice = applicationContext.getBean(EcommerceService.class);
		ecommerceservice.addManufacturer(new ManufacturerPO("502", "Xiaomi", "India", null));
		ecommerceservice.addProduct(new ProductsPO("104", "Redmi", "Mobile", 10000.0, "502"));
	}

	@State("Oppo")
	public void WithStateNewProductAndManfacturer() {
		System.out.println("something with state Product");
		EcommerceService ecommerceservice = applicationContext.getBean(EcommerceService.class);
		ecommerceservice.addManufacturer(new ManufacturerPO("504", "Oppo", "Uk", null));
		ecommerceservice.addProduct(new ProductsPO("105", "Oppo Reno Pro", "Mobile", 14000.0, "504"));
	}

}