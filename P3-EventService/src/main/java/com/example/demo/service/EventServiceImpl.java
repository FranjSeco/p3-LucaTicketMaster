package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepo;

@Service
public class EventServiceImpl implements EventService {
	
    @Autowired
    EventRepo eventItemRepo;
	
    
    // Create event items
    @Override
	public void createEventItems() {
		System.out.println("Data creation started...");
		eventItemRepo.save(new EventModel("Awakenings", "05-08-2022", "Rota", "Techno"));
		eventItemRepo.save(new EventModel("Cabo de plata", "12-08-2022", "Rota", "Varios"));
		eventItemRepo.save(new EventModel("Viejo agujetas", "1-09-2022", "Rota", "Cante jondo"));
        System.out.println("Data creation complete...");
	}
	
	// Show all the vents
    @Override
	public void showAllEvents() {
		eventItemRepo.findAll().forEach(event -> System.out.println(getItemDetails(event)));
	}
	
	// Get events by name
    @Override
	public void getEventByName(String name) {
		System.out.println("Getting event by name: " + name);
		EventModel event = eventItemRepo.findItemByName(name);
	}
	
	// Delete events
    @Override
    public void deleteEvent(String name) {
    	eventItemRepo.deleteById(name);
        System.out.println("Event " + name + " deleted...");
    }
    
    // Print details in readable form
    @Override
    public String getItemDetails(EventModel event) {

        System.out.println(
        "Item Name: " + event.getName() + 
        ", \nDate: " + event.getDate() +
        ", \nILocation: " + event.getLocation() +
        ", \nGenre:" + event.getGenre()
        );
        
        return "";
    }
    
    // Add events manually
    @Override
    public void addEvent(String name, String date, String location, String genre) {    	
    	eventItemRepo.save(new EventModel(name, date, location, genre));
    }
	
	//Get events by location
	
	//Get events by genre
	
}