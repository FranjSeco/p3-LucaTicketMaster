package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertNotNull;

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


@ExtendWith(SpringExtension.class)
@SpringBootTest()
@TestMethodOrder(OrderAnnotation.class)
class NewRegisterAddedToDataBaseTest {
	
	//Este test sustituiría el Test databaseSizeShouldIncreaseByOne()
	
	@Autowired
	UserRepository uRepo;
	
	
	@Test
	@Order(1)
	public void testNewUserAdded () {
		User user = new User();
	
		user.setId(13L);
		user.setUsername("BilboHobbit");
		user.setName("Bilbo");
		user.setLastname("Bolson");
		user.setEmail("bilbo@");
		user.setPassword("3");
		user.setDate("2890");
	
		uRepo.save(user);
		
		assertNotNull(uRepo.findByUsername("BilboHobbit").getUsername());
	}
	
	
	
	
	

}
