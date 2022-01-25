package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;

@Service
public class EventService {
	
    @Autowired
    EventRepository eventItemRepo;
	
	void createEventItems() {
		System.out.println("Data creation started...");
		eventItemRepo.save(new EventModel("Awakenings", "05-08-2022", "Rota", "Techno"));
	}
}
