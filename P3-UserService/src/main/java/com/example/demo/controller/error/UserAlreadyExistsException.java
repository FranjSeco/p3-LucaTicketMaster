package com.example.demo.controller.error;

public class UserAlreadyExistsException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistsException() {
		super("Fallo al registrarse, ya existe el usuario");
	}
	public UserAlreadyExistsException(String name) {
		super("Fallo al registrarse, ya existe el usuario " + name);
	}


}
