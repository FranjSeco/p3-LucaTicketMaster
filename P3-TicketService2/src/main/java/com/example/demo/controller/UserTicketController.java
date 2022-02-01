package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/ticket")
public class UserTicketController {
	
	private static final Logger log = LoggerFactory.getLogger(UserEvents.class);
	
	@Autowired
	UserFeignClient userFeign;
	
	@Autowired
	EventFeignClient eventFeign;
	
	@Operation(summary = "Buscar todos los eventos", description = "Cuando se hace la petición se devuelve una List<EventResponse> ", tags= {"event"})
		@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista localizada", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserEventsResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Lista no encontrada (NO implementado)", content = @Content) })
	  

	@PostMapping("/buyticket")
	public UserEventsResponse buyTicket(@RequestBody BodyModel data) {
 
		
		System.out.println("------------------------" + data);
		
		// llamada a microservicios user y eventos

		
		UserResponse usuario = userFeign.getDetails(data.getUserName());
		
		EventResponse evento = eventFeign.getDetails(data.getEventName());
		
		UserEventsResponse combo = new UserEventsResponse(usuario, evento);
		
		System.out.println("+++++++++++" + eventFeign.getDetails(data.getEventName()));
		
		log.info("Se accede al ticket");
		
		return combo;
	}
	
}
