package com.example.demo.response;

public class FinalResultResponse {
	private PaymentResponse codeResponse;
	private EventResponse eventResponse;
	
	
	public PaymentResponse getCodeResponse() {
		return codeResponse;
	}
	public void setCodeResponse(PaymentResponse codeResponse) {
		this.codeResponse = codeResponse;
	}
	public EventResponse getEventResponse() {
		return eventResponse;
	}
	public void setEventResponse(EventResponse eventResponse) {
		this.eventResponse = eventResponse;
	}
	public FinalResultResponse(PaymentResponse codeResponse, EventResponse eventResponse) {
		super();
		this.codeResponse = codeResponse;
		this.eventResponse = eventResponse;
	}
	public FinalResultResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
