package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI EventOpenApi() {
		return new OpenAPI()
				.info(new Info().title("Events API")
				.description("Documentacion de la Events API")
				.version("v1.0")
				.contact(new Contact().name("GRUPO 2").
                        url("https://grupo2.es").email("grupo@2.es"))
                .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("Microservicio que se encarga de la gestión de eventos en una base de MongoDB")
                .url("https://miproyectoGrupo2Event.es"));
	}

}
