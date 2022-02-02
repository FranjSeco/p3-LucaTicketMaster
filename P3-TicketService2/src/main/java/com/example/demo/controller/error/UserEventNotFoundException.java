package com.example.demo.controller.error;

public class UserEventNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserEventNotFoundException() {
		super("No se ha podido generar el ticket");
	}
	public UserEventNotFoundException(String name) {
		super("Error en la búsqueda: No existe el user "+name);
	}	

}