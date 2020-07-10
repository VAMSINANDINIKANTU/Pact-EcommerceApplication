package com.test.product1;

import java.util.Arrays;

import org.apache.http.HttpRequest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.test.provider1.EcommerceApplication;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.TargetRequestFilter;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@PactFolder("C:\\Users\\win10\\Desktop\\New-Pact-master\\New-Pact-master\\consumer1\\target\\pacts")
@Provider("EcommereceProvider")
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

	@State("HP")

	public void withSomeState() {

		System.out.println("get list of products from HP");

	}
}
