	package com.example.demo;

	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.assertNotNull;

	import org.junit.jupiter.api.Order;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.TestMethodOrder;
	import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit.jupiter.SpringExtension;

	import com.example.demo.model.User;
	import com.example.demo.repository.UserRepository;
	@ExtendWith(SpringExtension.class)
	@SpringBootTest()
	@TestMethodOrder(OrderAnnotation.class)
public class DeletedUser {


		@Autowired
		UserRepository uRepo;
		
		
		@Test
		@Order(1)
		public void shouldHaveDeletedUserTest () {
		
			User user = uRepo.findByUsername("8");
			uRepo.delete(user);
			assertThat(user).isNotIn(uRepo);
		}
		
	


}
