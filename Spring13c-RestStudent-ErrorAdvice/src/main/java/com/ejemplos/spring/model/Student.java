package com.ejemplos.spring.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Student {

	private Long id;
	@NotEmpty(message = "El nombre no debe ser vacío")
	private String firstName;
	@NotEmpty(message = "Necesitamos que indiques un apellido")	
	private String lastName;
	//@Max(value = 2022)
	//@Positive
	@Size(min=3, max=30)
	private String year;

	public Student() {
	}
	
	public Student(Long id, String firstname, String lastname, String year) {
		super();
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.year = year;
	}	

	public Student(String firstName, String lastName, String year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", year=" + year + "]";
	}

}
