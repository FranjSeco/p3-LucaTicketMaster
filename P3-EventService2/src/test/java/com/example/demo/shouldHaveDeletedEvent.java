package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;

@SpringBootTest
public class shouldHaveDeletedEvent {
	@Autowired
	EventService eventServiceTest;
	
	@Autowired
	EventRepository eventRepositoryTest;
	
	@Test
	void contextLoads() {
		// Given
		EventModel newEvent = new EventModel("Testing1","Testing1","Testing1","Testing1","Testing1");
		
		// When
		eventRepositoryTest.save(newEvent);
		eventServiceTest.deleteEvent("Testing1");
		
		// Then
		assertThat(eventRepositoryTest.findByName("Testing1")).isNull();
	}
}
