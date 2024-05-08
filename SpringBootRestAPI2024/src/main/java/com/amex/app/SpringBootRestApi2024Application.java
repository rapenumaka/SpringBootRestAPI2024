package com.amex.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="Spring Boot Rest API 2024",
				description = "Card microservice REST API Documentation",
				version = "1.0",
				contact = @Contact(
						name = "Raja Arvind Penumaka",
						email = "arvindrulzster@gmail.com"
				)
		)
)

public class SpringBootRestApi2024Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApi2024Application.class, args);
	}

}
