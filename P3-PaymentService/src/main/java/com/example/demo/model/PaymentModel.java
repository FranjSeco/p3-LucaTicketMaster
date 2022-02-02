package com.example.demo.model;

public class PaymentModel {
	private String paymentCode;
	private String paymentMsg;
	
	private String eventN;
	private String eventP;
	
	public PaymentModel() {
		super();
	}
	
	public PaymentModel(String paymentCode, String paymentMsg) {
		super();
		this.paymentCode = paymentCode;
		this.paymentMsg = paymentMsg;
	}

	
	public PaymentModel(String paymentCode, String paymentMsg, String eventN, String eventP) {
		super();
		this.paymentCode = paymentCode;
		this.paymentMsg = paymentMsg;
		this.eventN = eventN;
		this.eventP = eventP;
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
	


	@Override
	public String toString() {
		return "PaymentModel [paymentCode=" + paymentCode + ", paymentMsg=" + paymentMsg + ", eventN=" + eventN
				+ ", eventP=" + eventP + "]";
	}


	

}
