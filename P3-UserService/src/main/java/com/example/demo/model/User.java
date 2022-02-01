package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="User", description = "User Class")
@Entity
@Table(name="user")
public class User {

	@Schema(name= "id", 
    		description = "Identificador unico para el usuario", 
            example = "42", 
            required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Size (min = 0, max = 30)
	@Pattern(regexp= "^[^\\s]+$", message= "Este campo no admite espacios en blanco")
	@NotEmpty
	@Column(name="username")
	private String username;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastname;
	
	@Email
	@Column(name="email")
	private String email;
	
	@NotEmpty
	@Column(name="password")
	private String password;
	
	@Column(name="date")
	private String date;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	} 
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String userlastname) {
		this.lastname = userlastname;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", date=" + date + "]";
	}

	

	
	
	




	

	

	

	

	

}

