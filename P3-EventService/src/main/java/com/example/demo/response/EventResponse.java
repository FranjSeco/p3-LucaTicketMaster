package com.example.demo.response;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.EventModel;

public class EventResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(EventResponse.class);
	
	private String name;
	private String date;
	private String location;
	private String genre;
	
	public static EventResponse of(EventModel event) {
		EventResponse e = new EventResponse();
		e.setName(event.getName());
		e.setDate(event.getDate());
		e.setLocation(event.getLocation());
		e.setGenre(event.getGenre());
		
		return e;
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		EventResponse.log = log;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public static List<EventResponse> of(List<EventModel> events) {
		log.info("----- Eventos:" + events);
		return events.stream().map(e -> of(e)).collect(Collectors.toList());
	}

}
