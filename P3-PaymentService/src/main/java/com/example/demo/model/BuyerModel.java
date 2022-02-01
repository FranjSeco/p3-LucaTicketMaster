package com.example.demo.model;

public class BuyerModel {
	private String cardNumber;
	private String cardDate;
	private String cardCvv;
	private String cardName;
	
	public BuyerModel(String cardNumber, String cardDate, String cardCvv, String cardName) {
		super();
		this.cardNumber = cardNumber;
		this.cardDate = cardDate;
		this.cardCvv = cardCvv;
		this.cardName = cardName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardDate() {
		return cardDate;
	}
	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}
	public String getCardCvv() {
		return cardCvv;
	}
	public void setCardCvv(String cardCvv) {
		this.cardCvv = cardCvv;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	
}
