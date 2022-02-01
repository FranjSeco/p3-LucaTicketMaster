package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component("lame")
public class LamePasswordEncoder implements TipoPasswordEncoder{

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
