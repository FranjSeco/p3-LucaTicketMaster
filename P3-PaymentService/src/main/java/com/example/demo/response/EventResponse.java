package com.example.demo.response;

public class EventResponse {
	private String name;
	private String price;
	
	
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
	public EventResponse(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}
	public EventResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
