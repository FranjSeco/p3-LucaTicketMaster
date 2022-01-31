package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.controller.PaymentController;
import com.example.demo.response.PaymentResponse;

@Service
public class PaymentServiceImpl implements PaymentService {
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

	@Override
	public PaymentResponse processPayment() {
		// TODO Auto-generated method stub
		log.info("Se accede al procesamiento del pago");
		return null;
	}

}
