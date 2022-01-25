package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EventRepository;
import com.example.demo.response.EventResponse;
import com.example.demo.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired 
	private EventService eventService;
	
	@GetMapping("/")
	public List<EventResponse> getAllEvents() {
		return EventResponse.of(eventRepository.findAll());
	}
	
    @GetMapping("/{name}")
    public EventResponse getEventByName(@PathVariable String name) {
        return EventResponse.of(eventRepository.findItemByName(name));
    }
    
    @PostMapping("/{name}/add")
    public void addEvent(@PathVariable String name, @RequestParam String date, @RequestParam String location, @RequestParam String genre) {
    	eventService.addEvent(name, date, location, genre);
    }
}
