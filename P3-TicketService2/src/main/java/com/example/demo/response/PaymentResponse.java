package com.example.demo.response;

import java.io.Serializable;

public class PaymentResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String paymentCode;
	private String paymentMsg;
	private String eventName;
	private String eventPrice;
	
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(String eventPrice) {
		this.eventPrice = eventPrice;
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
