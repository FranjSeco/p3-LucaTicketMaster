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

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String userlastname;
	private String email;
	private String password;
	private String dateAlta;
	private Boolean enabled;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_role", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;

	public User() {
		super();
	}
	

	public User(Long id, String username, String userlastname, String email, String password, String dateAlta,
			Boolean enabled, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.userlastname = userlastname;
		this.email = email;
		this.password = password;
		this.dateAlta = dateAlta;
		this.enabled = enabled;
		this.roles = roles;
	}
	


	public User(String username, String userlastname, String email, String password, String dateAlta, Boolean enabled,
			Set<Role> roles) {
		super();
		this.username = username;
		this.userlastname = userlastname;
		this.email = email;
		this.password = password;
		this.dateAlta = dateAlta;
		this.enabled = enabled;
		this.roles = roles;
	}


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

	public Boolean isEnabled() {
		return enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getDateAlta() {
		return dateAlta;
	}

	public void setDateAlta(String dateAlta) {
		this.dateAlta = dateAlta;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userlastname=" + userlastname + ", email=" + email
				+ ", password=" + password + ", dateAlta=" + dateAlta + ", enabled=" + enabled + ", roles=" + roles
				+ "]";
	}

	

}
