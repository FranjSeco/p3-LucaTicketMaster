package com.example.demo.services;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
	public List<User> findAll();
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public User saveUser(User user);
	
	

}
