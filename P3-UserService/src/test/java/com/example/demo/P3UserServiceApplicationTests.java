package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
class P3UserServiceApplicationTests {
	
	
	@Autowired
	UserRepository uRepo;

	@Test
	public void testCreate() {
		
		/*User user = new User();
		
		user.setEmail("@user");	
		user.setUsername("Lu");
		user.getUserlastname();
		user.setPassword("jjsjs");
		user.setDateAlta("22/03/1991");
		
		uRepo.save(user);
		
		assertNotNull(uRepo.findById(1L).get());*/
		
		
		
		
	
	}

}
