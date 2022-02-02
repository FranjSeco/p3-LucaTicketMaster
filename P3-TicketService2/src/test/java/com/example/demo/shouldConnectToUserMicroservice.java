package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.feignClient.UserFeignClient;

@SpringBootTest
public class shouldConnectToUserMicroservice {
	
	//Given
	@Autowired
	UserFeignClient userFeign;
	
	@Test
	void contextLoads() {
		
		// When
		assertThat(userFeign.getDetails("Lu"))
		// Then
		.isNotNull();
		
	}

}
