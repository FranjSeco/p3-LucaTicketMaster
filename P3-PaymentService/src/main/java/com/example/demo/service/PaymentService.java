package com.example.demo.service;

import com.example.demo.model.PaymentModel;
import com.example.demo.response.PaymentResponse;

public interface PaymentService {
	
	//Para devolver un código de pago
	public PaymentModel processPayment();
	public PaymentModel processPayment(int code);
	public PaymentResponse paymentResult();

}
