package com.example.demo.controller.error;

public class EventNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EventNotFoundException() {
		super("Error en la búsqueda: No existe el evento");
	}
	public EventNotFoundException(String name) {
		super("Error en la búsqueda: No existe el evento "+name);
	}	

}