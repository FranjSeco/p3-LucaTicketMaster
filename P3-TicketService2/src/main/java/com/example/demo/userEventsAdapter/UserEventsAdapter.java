package com.example.demo.userEventsAdapter;

import org.springframework.stereotype.Component;

import com.example.demo.model.UserEvents;
import com.example.demo.response.UserEventsResponse;

@Component
public class UserEventsAdapter {
	public static UserEventsResponse of(UserEvents userEvent) {
		UserEventsResponse p = new UserEventsResponse();
		p.setUserName(userEvent.getUser().getUsername());
		p.setEventName(userEvent.getEvent().getName());

		return p;
	}
	
}
