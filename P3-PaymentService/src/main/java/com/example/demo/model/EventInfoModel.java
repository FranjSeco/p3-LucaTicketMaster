package com.example.demo.model;

public class EventInfoModel {
	private String name;
	private String price;
	
	
	
	public EventInfoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventInfoModel(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
