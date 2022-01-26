package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "eventlist")
public class EventModel {
	
	@Id
    private String id;
    private String name;
    private String date;
    private String location;
    private String genre;
    
    public EventModel(String id, String name, String date, String location, String genre) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.date = date;
    	this.location = location;
    	this.genre = genre;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "EventModel [id=" + id + ", name=" + name + ", date=" + date + ", location=" + location + ", genre="
				+ genre + "]";
	}
	
	
}
