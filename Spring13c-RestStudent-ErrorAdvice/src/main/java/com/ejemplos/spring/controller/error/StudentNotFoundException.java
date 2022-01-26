package com.ejemplos.spring.controller.error;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException() {
		super("Epic Fail: No existe el estudiante");
	}
	public StudentNotFoundException(Long id) {
		super("Epic Fail: No existe el estudiante "+id);
	}	

}
