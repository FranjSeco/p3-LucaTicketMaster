package com.example.demo.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "eventlist")
public class EventModel {
	
	@Id
    private String id;
	@NotEmpty(message = "El nombre no debe ser vacío")
    private String name;
    private String date;
    private String location;
    private String genre;
    private String price;
    
    
    public EventModel(String id, String name, String date, String location, String genre, String price) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.date = date;
    	this.location = location;
    	this.genre = genre;
    	this.price = price;
    }

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
