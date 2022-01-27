package com.example.demo.controller;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("Epic Fail: No existe el usuario");
	}
	public UserNotFoundException(Long id) {
		super("Epic Fail: No existe el usuario" + id);
	}

}
