package com.example.demo.model;

import javax.persistence.Entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="BodyModel", description = "BodyModel Class")
@Entity
public class BodyModel {
	
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
	@Override
	public String toString() {
		return "BodyModel [userName=" + userName + ", eventName=" + eventName + "]";
	}
	
	
}
