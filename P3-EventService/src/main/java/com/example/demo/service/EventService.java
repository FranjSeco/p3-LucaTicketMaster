package com.example.demo.service;

import com.example.demo.model.EventModel;

public interface EventService {
	
	// Create default Events
	public void createEventItems();
	
	// Show all the Events
	public void showAllEvents();
	
	//Get Events By Name
	public void getEventByName(String name);
	
	//Delete Events
	public void deleteEvent(String name);
	
	//Print details in a readable form 
	public String getItemDetails(EventModel event);
	
	// Add events manually
	public void addEvent(String name, String date, String location, String genre);
}