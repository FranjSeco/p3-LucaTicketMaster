package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.feignClient.EventFeignClient;


@SpringBootTest
public class shouldConnectToEventMicroservice {
	
	//Given
	@Autowired
	EventFeignClient eventFeign;
	
	@Test
	void contextLoads() {
		
		// When
		assertThat(eventFeign.getDetails("Testing1"))
		// Then
		.isNotNull();
		
	}
}
