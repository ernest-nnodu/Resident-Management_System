package com.jackalcode.resident_management_system;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Resident Management REST API Documentation",
				summary = "Spring Boot REST API documentation for Resident Management System",
				version = "v1.0",
				description = "API Provides CRUD Operations for residents, care interactions, and support plans"
		)
)
public class ResidentManagementSystemApplication {

	public static void main(String[] args) { SpringApplication.run(ResidentManagementSystemApplication.class, args);
	}

}
