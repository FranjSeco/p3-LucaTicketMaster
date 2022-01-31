package com.example.demo.response;

import java.io.Serializable;

import com.example.demo.model.EventModel;
import com.example.demo.model.User;
import com.example.demo.model.UserEvents;

public class UserEventsResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String eventName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	

	
}
