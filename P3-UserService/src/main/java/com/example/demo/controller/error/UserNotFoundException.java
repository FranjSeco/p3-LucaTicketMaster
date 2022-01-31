package com.example.demo.controller.error;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("Epic Fail: No existe el usuario");
	}
	public UserNotFoundException(String name) {
		super("Epic Fail: No existe el usuario" + name);
	}

}
