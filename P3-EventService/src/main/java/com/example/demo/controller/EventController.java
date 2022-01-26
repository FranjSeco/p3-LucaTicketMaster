package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.adapter.EventAdapter;
import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;
import com.example.demo.response.EventResponse;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventAdapter eventAdapter;
	
	
	@Autowired
	private EventRepository eventItemRepo;
	
	private static final Logger log = LoggerFactory.getLogger(EventController.class);

	@GetMapping
	public List<EventModel> getAllEvents() {
		log.info("Entrando a la ruta /event/");
		
		final List<EventModel> all = eventItemRepo.findAll();
		
		System.out.println(all);
		return all;
	}



	
	
	/*
    @GetMapping("/{name}")
    public EventResponse getEventByName(@PathVariable String name) {
        return EventResponse.of(eventRepository.findItemByName(name));
    }
    */
	
	/*
	
    @PostMapping("/{name}/add")
    public void addEvent(@PathVariable String name, @RequestParam String date, @RequestParam String location, @RequestParam String genre) {
    	eventService.addEvent(name, date, location, genre);
    }
    */
}
