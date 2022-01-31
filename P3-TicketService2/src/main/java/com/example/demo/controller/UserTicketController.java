package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feignClient.EventFeignClient;
import com.example.demo.feignClient.UserFeignClient;
import com.example.demo.model.BodyModel;
import com.example.demo.model.UserEvents;
import com.example.demo.response.EventResponse;
import com.example.demo.response.UserEventsResponse;
import com.example.demo.response.UserResponse;


@RestController
@RequestMapping("/ticket")
public class UserTicketController {
	
	@Autowired
	UserFeignClient userFeign;
	
	@Autowired
	EventFeignClient eventFeign;

	@PostMapping("/buyticket")
	public UserEventsResponse buyTicket(@RequestBody BodyModel data) {

		
		//double a = Math.random() * 10;  
		
		System.out.println("------------------------" + data);
		
		// llamada a microservicios user y eventos

		
		UserResponse usuario = userFeign.getDetails(data.getUserName());
		
		EventResponse evento = eventFeign.getDetails(data.getEventName());
		
		UserEventsResponse combo = new UserEventsResponse(usuario, evento);
		
		System.out.println("+++++++++++" + eventFeign.getDetails(data.getEventName()));
		
		return combo;
	}
	
}
