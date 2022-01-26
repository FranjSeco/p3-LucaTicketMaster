package com.ejemplos.spring.model;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="Student", description = "Student Class")
public class Student {

	//Lo usare para que aparezca en la documentacion
    @Schema(name= "id", 
    		description = "Identificador único para el estudiante", 
            example = "42", 
            required = true)
	private Long id;
	//Lo usare para que aparezca en la documentacion
	@Size(min = 0, max = 30)
	private String firstName;
	private String lastName;
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
