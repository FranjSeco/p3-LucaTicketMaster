package com.example.demo.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.model.EventModel;
import com.example.demo.response.EventResponse;

@Component
public class EventAdapter {
	
	public EventResponse of(EventModel event) {
		EventResponse eventResponse = new EventResponse();
		eventResponse.setId(event.getId());
		eventResponse.setName(event.getName());
		eventResponse.setDate(event.getDate());
		eventResponse.setName(event.getLocation());
		return eventResponse;
		}



		public List<EventResponse> of(List<EventModel> products) {
		return products.stream()
		.map(p -> of(p))
		.collect(Collectors.toList());
		}
}
