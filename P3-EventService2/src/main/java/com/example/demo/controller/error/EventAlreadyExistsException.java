package com.example.demo.controller.error;

public class EventAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EventAlreadyExistsException() {
		super("Error al crear evento. Ya existe");
	}
	public EventAlreadyExistsException(String name) {
		super("Error al crear evento. Ya existe el evento "+name);
	}	


}
