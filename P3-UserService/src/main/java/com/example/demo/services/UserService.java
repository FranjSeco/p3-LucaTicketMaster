package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.User;

public interface UserService {
	
	public List<User> findAll();
	public Optional<User> findById(long id);
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public User saveUser(User user);
	//para el login
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;
	
	

}
