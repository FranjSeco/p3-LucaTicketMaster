package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
class P3UserServiceApplicationTests {
	
	
	@Autowired
	UserRepository uRepo;
	
	private int port = 3306;
	
    //Lo usaremos para llamar al servicio REST
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void shouldHaveConnectedTheDatabase() {
		assertThat(restTemplate.getForObject("jdbc:mysql://localhost:" + port + "/userSecurity", String.class)).contains("Hola Mundo");
	}
	/*@Test
	public void testCreate() {
		
		/*User user = new User();
		
		user.setEmail("@user");	
		user.setUsername("Lu");
		user.getUserlastname();
		user.setPassword("jjsjs");
		user.setDateAlta("22/03/1991");
		
		uRepo.save(user);
		
		assertNotNull(uRepo.findById(1L).get());*/
			
	
	//}

}
