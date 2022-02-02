package com.example.demo.model;

import com.example.demo.response.EventResponse;
import com.example.demo.response.PaymentResponse;

public class ResultModel {
	private PaymentResponse paymentResult;
	private EventResponse eventInfoResult;
	
	
	
	public ResultModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultModel(PaymentResponse paymentResult, EventResponse eventInforesult) {
		super();
		this.paymentResult = paymentResult;
		this.eventInfoResult = eventInforesult;
	}
	public PaymentResponse getPaymentResult() {
		return paymentResult;
	}
	public void setPaymentResult(PaymentResponse paymentResult) {
		this.paymentResult = paymentResult;
	}
	public EventResponse getEventInfoResult() {
		return eventInfoResult;
	}
	public void setEventInforesult(EventResponse eventInforesult) {
		this.eventInfoResult = eventInforesult;
	}
	
	
	
}
