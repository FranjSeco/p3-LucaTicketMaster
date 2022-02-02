package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.EventResponse;
import com.example.demo.response.FinalResultResponse;
import com.example.demo.response.PaymentResponse;
import com.example.demo.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/payment")
@Tag(name ="payment", description = "Payment API")
public class PaymentController {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	PaymentService paymentService;
	
	@Operation(summary = "Solicitud de pago", description = "Cuando se hace la petición se devuelve un código de pago y un mensaje ", tags= {"payment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pago completado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Lista no encontrada (NO implementado)", content = @Content) })
	
	@PostMapping()
	public FinalResultResponse processPayment(String name, String price) {
		
		EventResponse eventInfo = new EventResponse(name, price);
		
		PaymentResponse paymentInfo = new PaymentResponse(paymentService.processPayment());
		
		FinalResultResponse finalResult = new FinalResultResponse(paymentInfo, eventInfo);
		
		log.info("Se accede a la plataforma de pago");
		
		return finalResult;
		
	}
	

}
