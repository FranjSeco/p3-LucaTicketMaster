package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EventModel;
import com.example.demo.response.EventResponse;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

   private static final Logger log = LoggerFactory.getLogger(EventController.class);

   @Autowired
   private EventService eventService;
   
   @GetMapping
   public List<EventModel> getAll() {
	   log.info("Se accede al controllador");
	   return eventService.showAllEvents();
   }
   
   @PostMapping("/add")
   public EventResponse addEvent(@RequestBody EventModel event) {
	   return eventService.addEvent(event);
   }
   
   @GetMapping("/{name}")
   public EventResponse getDetails(@PathVariable String name) {
	   return eventService.getDetails(name);
   }
   
   @PutMapping("/{name}")
   public EventResponse modifyEvent(@PathVariable String name, @RequestBody EventModel event) {
	   return eventService.findByIdAndUpdate(name, event);
   }
   
   @DeleteMapping("/{name}")
   public EventResponse deleteEvent(@PathVariable String name) {
	   return eventService.deleteEvent(name);
   }
   

}