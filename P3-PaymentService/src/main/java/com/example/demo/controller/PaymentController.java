package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.adapter.PaymentAdapter;
import com.example.demo.model.PaymentModel;
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
	
	@Autowired
	PaymentAdapter paymentAdapter;
	
	@Operation(summary = "Solicitud de pago", description = "Cuando se hace la petición se devuelve un código de pago y un mensaje ", tags= {"payment"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pago completado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Lista no encontrada (NO implementado)", content = @Content) })
	
	@GetMapping("/{eventName}/{eventPrice}")
	public PaymentResponse processPayment(@PathVariable String eventName, @PathVariable String eventPrice) {
		
		log.info("Se accede a la plataforma de pago");
		
		String eventN = eventName;
		
		String eventP = eventPrice;
		
		PaymentModel resultado = new PaymentModel();
		
		resultado.setEventP(eventP);
		resultado.setEventN(eventN);
		resultado.setPaymentCode(paymentService.paymentResult().getPaymentCode());
		resultado.setPaymentMsg(paymentService.paymentResult().getPaymentMsg());
		
		return paymentAdapter.of(resultado);
		
	}
	

}
