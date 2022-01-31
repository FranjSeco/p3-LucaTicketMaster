package com.example.demo.model;

import com.example.demo.response.EventResponse;
import com.example.demo.response.UserResponse;

public class UserEvents {
	
	private UserResponse User;

	private EventResponse Event;
	
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

	
}
