package com.example.demo.services;

import com.example.demo.model.User;

public interface UserService {
	
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public void saveUser(User user);

}
