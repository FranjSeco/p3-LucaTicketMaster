package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;

@SpringBootTest
public class databaseSizeShouldIncreaseByOne {
	@Autowired
	EventService eventServiceTest;
	
	@Autowired
	EventRepository eventRepositoryTest;
	
	@Test
	void contextLoads() {
		// Given
		int initialSize;
		
		if (eventRepositoryTest.findAll() == null) {
			initialSize = 0;
		} else {
			initialSize = eventRepositoryTest.findAll().size();
		}
		
		// When
		EventModel newEvent = new EventModel("123123126831723","Testing1","Testing1","Testing1","Testing1");
		eventRepositoryTest.save(newEvent);
		
		// Then
		assertThat(eventRepositoryTest.findAll().size()).isEqualTo(initialSize + 1);
	}

}
