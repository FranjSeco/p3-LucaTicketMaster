package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncoderConfig{

	//Permite instanciar este objeto que se inyectara en la otra configuracion
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		System.out.println("--- Inside passwordEncoder");
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}