package com.example.AlticeLabsExercise;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@OpenAPIDefinition(
		info = @Info(
				title = "LabSeq REST API Documentation",
				description = "Documentation for the LabSeq REST API, providing endpoints to calculate and retrieve values of the LabSeq sequence.",
				version = "v1",
				contact = @Contact(
						name = "Lucas Andrade",
						email = "rissiandrade@gmail.com"
				),
				license = @License(
						name = "Apache License 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0.html"
				)
		)
)


@SpringBootApplication
@EnableCaching
public class AlticeLabsExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlticeLabsExerciseApplication.class, args);
	}

}
