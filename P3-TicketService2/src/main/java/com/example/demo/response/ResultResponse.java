package com.example.demo.response;

public class ResultResponse {

	private UserEventsResponse ticketInfoResponse;
	private PaymentResponse paymentInfoResponse;
	
	
	
	public ResultResponse(UserEventsResponse ticketInfoResponse, PaymentResponse paymentInfoResponse) {
		super();
		this.ticketInfoResponse = ticketInfoResponse;
		this.paymentInfoResponse = paymentInfoResponse;
	}

	public ResultResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEventsResponse getTicketInfoResponse() {
		return ticketInfoResponse;
	}
	public void setTicketInfoResponse(UserEventsResponse ticketInfoResponse) {
		this.ticketInfoResponse = ticketInfoResponse;
	}
	public PaymentResponse getPaymentInfoResponse() {
		return paymentInfoResponse;
	}
	public void setPaymentInfoResponse(PaymentResponse paymentInfoResponse) {
		this.paymentInfoResponse = paymentInfoResponse;
	}
	
}
