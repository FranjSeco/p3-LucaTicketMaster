package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class P3ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(P3ConfigServerApplication.class, args);
	}

}
