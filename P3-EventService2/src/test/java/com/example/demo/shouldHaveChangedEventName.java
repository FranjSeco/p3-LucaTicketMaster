package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;

@SpringBootTest
public class shouldHaveChangedEventName {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EventService eventService;

    

	@Test
	public void test() {
		assertFalse(eventService.showAllEvents().isEmpty());
		
	}

}
