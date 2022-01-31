package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.UserEventsResponse;


@RestController
@RequestMapping("/ticket")
public class UserTicketController {

	@PostMapping("/buyticket/{data}")
	public double buyTicket(@RequestBody UserEventsResponse data) {

		

		
		
		double a = Math.random() * 10;  
		
		
		
		return a;
	}
	
}
