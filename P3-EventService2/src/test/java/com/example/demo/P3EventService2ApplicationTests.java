package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.EventService;

@SpringBootTest
class P3EventService2ApplicationTests {
	
	@Autowired
	EventService eventServiceTest;
	

	@Test
	void contextLoads() {
		assertFalse(eventServiceTest.showAllEvents().isEmpty());
	}

}
