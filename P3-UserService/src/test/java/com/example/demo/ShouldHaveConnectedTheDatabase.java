package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest()
class ShouldHaveConnectedTheDatabase {
	
	
	@Autowired
	UserRepository uRepo;
	
	@Test
	public void testRead () {
		User user = uRepo.findByUsername(user)
		assertEquals("iPhone XR", user.getUsername());
	}
	


}
