package com.example.demo.response;

public class ResultResponse {

	private UserEventsResponse ticketInfoResponse;
	private PaymentResponse paymentInfoResponse;
	private String precioFinal;
	
	
	
	public ResultResponse(UserEventsResponse ticketInfoResponse, PaymentResponse paymentInfoResponse,
			String precioFinal) {
		super();
		this.ticketInfoResponse = ticketInfoResponse;
		this.paymentInfoResponse = paymentInfoResponse;
		this.precioFinal = precioFinal;
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
	public String getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(String precioFinal) {
		this.precioFinal = precioFinal;
	}
	
}
