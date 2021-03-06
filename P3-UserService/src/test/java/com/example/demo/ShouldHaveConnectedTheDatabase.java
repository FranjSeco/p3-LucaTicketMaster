
package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

//@ExtendWith(SpringExtension.class)
@SpringBootTest()
@TestMethodOrder(OrderAnnotation.class)
class ShouldHaveConnectedTheDatabase {
	
	
	@Autowired
	UserRepository uRepo;
	

	@Test
	@Order(1)
	public void ExistsDatabaseTest () {
		
	
		assertThat(uRepo).isNotNull();
	}
	
	
	@Test
	@Order(2)
	public void ConnectedTheDatabaseTest () {
		
		User user = uRepo.findByUsername("Bea");
		assertThat(user).isNotNull();
	}

	


}

