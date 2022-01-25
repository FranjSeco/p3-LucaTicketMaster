package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("hash")
public class HashPasswordEncoder implements TipoPasswordEncoder{

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("--- Hash encode");	
		return bCryptPasswordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("--- Hash decode");
		return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
	}

}
