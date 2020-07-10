package com.test.product1;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;

//import com.bookshopapp.ApiProviderPact1Application;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)

@Provider("EcommereceProvider")

//@PactBroker( host = "https://sm.pact.dius.com.au/", port = "443")
@PactBroker
//(host = "${pactbroker.url:'https://sm.pact.dius.com.au/'}", port = "443")

@VerificationReports(value = { "console", "markdown", "json" })

public class Product1BrokerTest {

	private int PORT = 9080;

	@BeforeClass

	public static void setVersion() {

		// https://github.com/DiUS/pact-jvm/tree/master/provider/pact-jvm-provider-junit#publishing-verification-results-to-a-pact-broker

		System.setProperty("pact.provider.version", "1.0.0");

		System.setProperty("pact.verifier.publishResults", "true");

	}

	@BeforeClass
	public static void start() {

		// applicationContext = SpringApplication.run(Pro.class);

	}

	@TestTarget

	public final Target target = new HttpTarget("http", "localhost", PORT);

	@State("HP")

	public void withSomeState() {

		System.out.println("get list of products from HP");

	}
}
