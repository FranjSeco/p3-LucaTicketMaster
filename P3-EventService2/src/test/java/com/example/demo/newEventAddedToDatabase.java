package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;

@SpringBootTest
public class newEventAddedToDatabase {
	@Autowired
	EventRepository eventRepositoryTest;
	
	@Test
	void contextLoads() {
		// Given a data base
		assertThat(eventRepositoryTest.findByName("Testing1")).isNull();
		
		// When
		EventModel newEvent = new EventModel("Testing1","Testing1","Testing1","Testing1","Testing1");
		eventRepositoryTest.save(newEvent);
		
		// Then
		assertThat(eventRepositoryTest.findByName(newEvent.getName())).isNotNull();
	}
}
