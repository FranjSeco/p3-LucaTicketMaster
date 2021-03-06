package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feignClient.EventFeignClient;
import com.example.demo.feignClient.PaymentFeignClient;
import com.example.demo.feignClient.UserFeignClient;
import com.example.demo.model.BodyModel;
import com.example.demo.model.UserEvents;
import com.example.demo.response.EventResponse;
import com.example.demo.response.PaymentResponse;
import com.example.demo.response.ResultResponse;
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
	
	@Autowired
	PaymentFeignClient paymentFeign;
	
	@Operation(summary = "Llevar a cabo la compra de un ticket", description = "Cuando se hace la petición se devuelve una un ticket de un evento asignado a un usuario.", tags= {"ticket"})
		@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Compra llevada a cabo con exito.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserEventsResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Informacion necesaria no encontrada (NO implementado)", content = @Content) })
	  

	@PostMapping("/buyticket")
	public ResultResponse buyTicket(@RequestBody BodyModel data) {
		
		UserResponse usuario = userFeign.getDetails(data.getUserName());
		
		EventResponse evento = eventFeign.getDetails(data.getEventName());
		
		UserEventsResponse combo = new UserEventsResponse(usuario, evento);
		
		PaymentResponse paymentPlatform = paymentFeign.processPayment(evento.getName(), evento.getPrice());
		
		String precio = "El precio del ticket es " + evento.getPrice() + " Euros";
		
		ResultResponse result = new ResultResponse(combo, paymentPlatform, precio);		
		
		log.info("Se accede al ticket");
		
		return result;
	}
	

}
