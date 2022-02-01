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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/ticket")
@Tag(name = "ticketEvent", description = "Ticket API")
public class UserTicketController {
	
	@Autowired
	UserFeignClient userFeign;
	
	@Autowired
	EventFeignClient eventFeign;
	
	// Metodo para comprar ticket: info de usuario y evento se pedira desde aqui
	@Operation(summary = "Realizar la compra de un ticket", description = "Cuando se hace la petición devuelve una respuesta. Puede ser negativa, por lo que no se habra llevado a cabo la compra", tags= {"ticketEvent"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Compra realizada con exito", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserEvents.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Informacion no encontrado (NO implementado)", content = @Content) })

	@PostMapping("/buyticket")
	public UserEventsResponse buyTicket(@RequestBody BodyModel data) {

		
		System.out.println("------------------------" + data);

		
		UserResponse usuario = userFeign.getDetails(data.getUserName());
		
		EventResponse evento = eventFeign.getDetails(data.getEventName());
		
		UserEventsResponse combo = new UserEventsResponse(usuario, evento);
		
		System.out.println("+++++++++++" + eventFeign.getDetails(data.getEventName()));
		
		return combo;
	}
	
}
