package com.example.demo.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.example.demo.response.EventResponse;
import com.example.demo.response.UserResponse;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="UserEvents", description = "UserEvents Class")
@Entity
public class UserEvents {
	@NotEmpty(message = "Usuario no debe estar vacío")
	private UserResponse User;
	@NotEmpty(message = "El evento no debe estar vacío")
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

	@Override
	public String toString() {
		return "UserEvents [User=" + User + ", Event=" + Event + "]";
	}

	
}
