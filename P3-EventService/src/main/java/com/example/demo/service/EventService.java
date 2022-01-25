package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;

@Service
public class EventService {
	
    @Autowired
    EventRepository eventItemRepo;
	
    
    // Create event items
	void createEventItems() {
		System.out.println("Data creation started...");
		eventItemRepo.save(new EventModel("Awakenings", "05-08-2022", "Rota", "Techno"));
		eventItemRepo.save(new EventModel("Cabo de plata", "12-08-2022", "Rota", "Varios"));
		eventItemRepo.save(new EventModel("Viejo agujetas", "1-09-2022", "Rota", "Cante jondo"));
        System.out.println("Data creation complete...");
	}
	
	// Show all the data
	public void showAllEvents() {
		eventItemRepo.findAll().forEach(event -> System.out.println(getItemDetails(event)));
	}
	
	// Get events by name
	public void getEventByName(String name) {
		System.out.println("Getting event by name: " + name);
		EventModel event = eventItemRepo.findItemByName(name);
	}
	
	// Delete events
    public void deleteEvent(String name) {
    	eventItemRepo.deleteById(name);
        System.out.println("Event " + name + " deleted...");
    }
    
    // Print details in readable form
    
    public String getItemDetails(EventModel event) {

        System.out.println(
        "Item Name: " + event.getName() + 
        ", \nDate: " + event.getDate() +
        ", \nILocation: " + event.getLocation() +
        ", \nGenre:" + event.getGenre()
        );
        
        return "";
    }
    
    public void addEvent(String name, String date, String location, String genre) {    	
    	eventItemRepo.save(new EventModel(name, date, location, genre));
    }
	
	//Get events by location
	
	//Get events by genre
	
}
