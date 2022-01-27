package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EventAdapter.EventAdapter;
import com.example.demo.controller.EventController;
import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;
import com.example.demo.response.EventResponse;

@Service
public class EventServiceImpl implements EventService {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);


    @Autowired
    EventRepository eventRepository;
    
    @Autowired
    EventAdapter eventAdapter;

	@Override
	public List<EventModel> showAllEvents() {
		// TODO Auto-generated method stub
		log.info("Se accede al Servicio Impl");
		System.out.println("-------------" + eventRepository.findAll());
		return eventRepository.findAll();
	}
    
    @Override
    public EventResponse addEvent(EventModel event) {
    	eventRepository.save(event);
    	System.out.println("----------------" + event);
    	return eventAdapter.of(event);
    }

	@Override
	public EventResponse getDetails(String name) {
		// TODO Auto-generated method stub
		EventResponse event = null;
		try {
			 event = eventAdapter.of(eventRepository.findByName(name));
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		return event;
	}

	@Override
	public EventResponse findByIdAndUpdate(String name, EventModel event) {
		// TODO Auto-generated method stub
		EventModel eUpdater = eventRepository.findByName(name);
		
		eUpdater.setName(event.getName());
		eUpdater.setDate(event.getDate());
		eUpdater.setLocation(event.getLocation());
		eUpdater.setGenre(event.getGenre());
		
		eventRepository.save(eUpdater);
		
		return eventAdapter.of(eUpdater);
	}

	@Override
	public EventResponse deleteEvent(String name) {
		// TODO Auto-generated method stub
		EventModel eUpdater = eventRepository.findByName(name);
		
		eventRepository.deleteById(eUpdater.getId());
		
		return eventAdapter.of(eUpdater);
	}
    
    
} 