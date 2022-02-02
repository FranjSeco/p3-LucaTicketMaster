package com.example.demo.adapter;

import org.springframework.stereotype.Component;

import com.example.demo.model.PaymentModel;
import com.example.demo.response.PaymentResponse;

@Component
public class PaymentAdapter {
	
	public PaymentResponse of(PaymentModel payment) {
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setPaymentCode(payment.getPaymentCode());
		paymentResponse.setPaymentMsg(payment.getPaymentMsg());
		paymentResponse.setEventN(payment.getEventN());
		paymentResponse.setEventP(payment.getEventP());
		
		System.out.println("En paymentAdapter------" + paymentResponse);
		
		return paymentResponse;
	}

}
