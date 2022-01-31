package com.example.demo.response;

import java.io.Serializable;

import com.example.demo.model.EventModel;
import com.example.demo.model.User;

public class UserEventsResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UserResponse user;
	private EventResponse event;
	public UserResponse getUser() {
		return user;
	}
	public void setUser(UserResponse userResponse) {
		this.user = userResponse;
	}
	public EventResponse getEvent() {
		return event;
	}
	public void setEvent(EventResponse eventResponse) {
		this.event = eventResponse;
	}
	
	
}
