package com.example.demo.response;

import java.io.Serializable;

public class PaymentResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String paymentCode;
	private String paymentMsg;
	
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
