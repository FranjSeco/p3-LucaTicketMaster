package com.example.demo.response;

import java.io.Serializable;

public class UserEventsResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UserResponse user;
	private EventResponse event;
	private String precio;
	
	
	public UserEventsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserEventsResponse(UserResponse userName, EventResponse eventName, String precio) {
		super();
		this.user = userName;
		this.event = eventName;
		this.precio = precio;
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


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	


	
}
