package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="User", description = "User Class")
@Entity
public class User {

	@Schema(name= "id", 
    		description = "Identificador unico para el usuario", 
            example = "42", 
            required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size (min = 0, max = 30)
	@Pattern(regexp= "^[^\\d\\s]+$", message= "Username no admite espacios en blanco")
	private String username;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private String date;
	private Boolean enabled;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_role", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
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

	public Boolean isEnabled() {
		return enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", date=" + date + ", enabled=" + enabled
				+ "]";
	}
	
	




	

	

	

	

	

}

