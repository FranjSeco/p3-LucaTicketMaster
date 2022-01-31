package com.example.demo.userEventsAdapter;

import org.springframework.stereotype.Component;

import com.example.demo.model.UserEvents;
import com.example.demo.response.UserEventsResponse;

@Component
public class UserEventsAdapter {
	public UserEventsResponse of (UserEvents userEvent ) {
		UserEventsResponse userEventResponse = new UserEventsResponse();
		userEventResponse.setUser(userEvent.getUser());
		userEventResponse.setEvent(userEvent.getEvent());
		return userEventResponse;
	}
	
}
