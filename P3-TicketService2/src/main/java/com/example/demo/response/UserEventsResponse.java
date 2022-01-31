package com.example.demo.response;

import java.io.Serializable;

import com.example.demo.model.EventModel;
import com.example.demo.model.User;
import com.example.demo.model.UserEvents;

public class UserEventsResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UserResponse user;
	private EventResponse event;
	
	
	public UserEventsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserEventsResponse(UserResponse userName, EventResponse eventName) {
		super();
		this.user = userName;
		this.event = eventName;
	}


	public UserResponse getUser() {
		return user;
	}
	public void setUser(UserResponse userName) {
		this.user = userName;
	}
	public EventResponse getEvent() {
		return event;
	}
	public void setEvent(EventResponse eventName) {
		this.event = eventName;
	}
	


	
}
