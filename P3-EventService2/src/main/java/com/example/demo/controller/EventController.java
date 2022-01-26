package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EventModel;
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

}