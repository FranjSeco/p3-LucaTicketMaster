package com.ejemplos.spring.security;

import org.springframework.stereotype.Component;

//Es un componente especial para aprovechar las ventajas
//del encriptador de Spring
@Component("lame")
public class LamePasswordEncoder implements TipoPasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("--- Lame encode");
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("--- Lame decode");		
		return rawPassword.toString().equals(encodedPassword);
	}

}