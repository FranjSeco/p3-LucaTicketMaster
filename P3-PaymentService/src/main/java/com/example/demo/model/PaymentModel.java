package com.example.demo.model;

public class PaymentModel {
	private String paymentCode;
	private String paymentMsg;
	
	public PaymentModel(String paymentCode, String paymentMsg) {
		super();
		this.paymentCode = paymentCode;
		this.paymentMsg = paymentMsg;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pago finalizado con código "+paymentCode+": "+paymentMsg;
	}
	

}
