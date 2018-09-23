package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * TestNG official documentation: http://testng.org/doc/documentation-main.html
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringDemoApplicationTestsBase extends AbstractTestNGSpringContextTests {
	@Autowired
	protected TestRestTemplate restTemplate;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite...");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite...");
	}

	@Test
	public void contextLoads() {
	}

	@AfterMethod
	public void cleanUp() {
		System.out.println("Test end...");
	}
}
