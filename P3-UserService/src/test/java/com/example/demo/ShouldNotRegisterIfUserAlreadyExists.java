package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@TestMethodOrder(OrderAnnotation.class)
class ShouldNotRegisterIfUserAlreadyExists {
	
	
	@Autowired
	UserRepository uRepo;
	
	
	@Test
	@Order(1)
	public void UserAlreadyExistsTest () {
		
		User user = uRepo.findByUsername("Claudia");
		
		assertThat(user.getUsername()).isEqualToIgnoringCase("Claudia");
		/*User user = new User();
	
		user.setId(12L);
		user.setUsername("Claudia");
		user.setUserlastname("Leon");
		user.setEmail("65767");
		user.setPassword("Clau@");
		user.setDate("1991");
		
		
		
		assertThat(user.equals(uRepo.findByUsername("Claudia")));*/
	}
	
	
	
	
	

}
