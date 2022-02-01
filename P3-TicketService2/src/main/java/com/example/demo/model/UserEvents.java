package com.example.demo.model;

import com.example.demo.response.EventResponse;
import com.example.demo.response.UserResponse;

public class UserEvents {
	
	private UserResponse User;

	private EventResponse Event;
	
	private String precio;
	
	public UserEvents() {
	}
	
	public UserEvents(UserResponse user, EventResponse event) {
		super();
		User = user;
		Event = event;
	}

	public UserResponse getUser() {
		return User;
	}

	public void setUser(UserResponse user) {
		User = user;
	}

	public EventResponse getEvent() {
		return Event;
	}

	public void setEvent(EventResponse event) {
		Event = event;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "UserEvents [User=" + User + ", Event=" + Event + ", precio=" + precio + "]";
	}

	
	
}
