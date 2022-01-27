package com.example.demo.response;
import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.User;

public class EventResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(EventResponse.class);
	
	private String id;
	private String name;
	private String date;
	private String location;
	private String genre;

	
	/*public static EventResponse of(UserResponse userR) {
		EventResponse u = new EventResponse();
		u.setId(userR.getId());
		u.setName(userR.getName());
		u.setDate(userR.getDate());
		u.setLocation(userR.geLocation);
		return u;
	}*/
	
	
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


}
