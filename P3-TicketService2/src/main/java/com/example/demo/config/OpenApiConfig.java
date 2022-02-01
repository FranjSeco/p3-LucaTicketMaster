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
	public OpenAPI TicketOpenApi() {
		return new OpenAPI()
				.info(new Info().title("Ticket API")
				.description("Documentacion del Ticket API")
				.version("v1.0")
				.contact(new Contact().name("GRUPO 2").
                        url("https://grupo2.es").email("grupo@2.es"))
                .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("Microservicio que se encarga de gestionar la compra de entradas. Recibe un nombre de usuario y un nombre de evento, busca la informacion relacionada con ambos, y hace una peticion a la plataforma de pago para llevar a cabo la transaccion.")
                .url("https://miproyectoGrupo2Ticket.es"));
	}

}
