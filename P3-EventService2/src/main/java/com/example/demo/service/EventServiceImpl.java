package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.EventController;
import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);


    @Autowired
    EventRepository eventRepository;


	@Override
	public List<EventModel> showAllEvents() {
		// TODO Auto-generated method stub
		log.info("Se accede al Servicio Impl");
		System.out.println("-------------" + eventRepository.findAll());
		return eventRepository.findAll();
	}
    


} 