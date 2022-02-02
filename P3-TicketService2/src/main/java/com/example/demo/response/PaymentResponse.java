package com.example.demo.response;

import java.io.Serializable;

public class PaymentResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String paymentCode;
	private String paymentMsg;
	
	private String eventN;
	private String eventP;
	
	
	public String getEventN() {
		return eventN;
	}

	public void setEventN(String eventN) {
		this.eventN = eventN;
	}

	public String getEventP() {
		return eventP;
	}

	public void setEventP(String eventP) {
		this.eventP = eventP;
	}

	public PaymentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getPaymentMsg() {
		return paymentMsg;
	}
	public void setPaymentMsg(String paymentMsg) {
		this.paymentMsg = paymentMsg;
	}
	
}
