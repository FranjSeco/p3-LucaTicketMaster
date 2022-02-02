package com.example.demo.service;

import com.example.demo.response.PaymentResponse;

public interface PaymentService {
	
	//Para devolver un código de pago
	public PaymentResponse processPayment();
	public PaymentResponse processPayment(int code);

}
