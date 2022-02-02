package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;

@SpringBootTest
public class databaseConnectionSuccessful {
	@Autowired
	EventRepository eventRepositoryTest;
	
	@Test
	void contextLoads() {
		// Given
		EventModel newEvent = new EventModel("Testing1","Testing1","Testing1","Testing1","Testing1","Testing1");
		
		// When
		eventRepositoryTest.save(newEvent);
		
		// Then
		assertThat(eventRepositoryTest.findByName("Testing1")).isNotNull();
	}
}
