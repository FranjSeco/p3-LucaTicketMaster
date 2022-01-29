package com.example.demo.controller.error;

public class IncorrectPasswordException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public IncorrectPasswordException() {
		super("La contraseña es incorrecta");
	}
	public IncorrectPasswordException(String name) {
		super("La contraseña es incorrecta para el usuario " + name);
	}


}
