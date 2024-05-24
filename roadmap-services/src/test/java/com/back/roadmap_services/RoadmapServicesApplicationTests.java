package com.back.roadmap_services;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;


import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoadmapServicesApplicationTests {
	@ServiceConnection
	private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:latest");

	@LocalServerPort
	private Integer port;

	@BeforeEach 
	void setup() {
		RestAssured.port = this.port;
		RestAssured.baseURI = "http://localhost/api/v1";
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void itShouldCreateARoadmap() {
		String requestBody = """
			{
				"name" : "test",
				"description" : "some descirption",
				"color" : "#019283",
				"orderValue" : 0,
				"userId" : 1
				}
				""";

		RestAssured.given().body(requestBody)
		.contentType("application/json")
		.when()
		.post("/roadmap")
		.then()
		.statusCode(200)
		.body("id",Matchers.notNullValue())
		.body("name", Matchers.equalTo("test"))
		.body("description", Matchers.equalTo("some descirption"))
		.body("color", Matchers.equalTo("#019283"))
		.body("orderValue", Matchers.equalTo(0))
		.body("userId", Matchers.equalTo(1));

	}

}
