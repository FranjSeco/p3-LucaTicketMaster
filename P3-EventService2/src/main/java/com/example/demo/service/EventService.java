package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EventModel;
import com.example.demo.response.EventResponse;


public interface EventService  {
	
	// Show all the Events
	public List<EventModel> showAllEvents();
	
	// Add event
	public EventResponse addEvent(EventModel event);
}
