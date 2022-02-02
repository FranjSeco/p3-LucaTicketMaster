package com.example.demo.adapter;

import org.springframework.stereotype.Component;

import com.example.demo.model.PaymentModel;
import com.example.demo.model.ResultModel;
import com.example.demo.response.FinalResultResponse;
import com.example.demo.response.PaymentResponse;

@Component
public class PaymentAdapter {

	
	public PaymentResponse of(PaymentModel payment) {
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setPaymentCode(payment.getPaymentCode());
		paymentResponse.setPaymentMsg(payment.getPaymentMsg());
		return paymentResponse;
	}

}
