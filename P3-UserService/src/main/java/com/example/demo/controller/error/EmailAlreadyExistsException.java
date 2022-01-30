package com.example.demo.controller.error;

public class EmailAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyExistsException() {
		super("Fallo al registrarse, ya existe el email");
	}
	public EmailAlreadyExistsException(String email) {
		super("Fallo al registrarse, ya existe el email " + email);
	}
}
