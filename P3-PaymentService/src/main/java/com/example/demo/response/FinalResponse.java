package com.example.demo.response;

public class FinalResponse {
	private PaymentResponse paymentResponse;
	private EventResponse eventResponse;
	
	
	public PaymentResponse getPaymentResponse() {
		return paymentResponse;
	}
	public void setPaymentResponse(PaymentResponse paymentResponse) {
		this.paymentResponse = paymentResponse;
	}
	public EventResponse getEventResponse() {
		return eventResponse;
	}
	public void setEventResponse(EventResponse eventInfoModel) {
		this.eventResponse = eventInfoModel;
	}
	public FinalResponse(PaymentResponse paymentResponse, EventResponse eventResponse) {
		super();
		this.paymentResponse = paymentResponse;
		this.eventResponse = eventResponse;
	}
	public FinalResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
