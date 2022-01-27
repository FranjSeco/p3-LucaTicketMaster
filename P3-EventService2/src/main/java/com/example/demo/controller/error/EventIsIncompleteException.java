package com.example.demo.controller.error;

public class EventIsIncompleteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EventIsIncompleteException(String name, String date, String location, String genre) {
		super("Error al crear evento. Informacion incompleta Nombre: " + name + ", Fecha: "+ date + ", Localizacion: " + location + ", Genero: " + genre);
	}	
}
