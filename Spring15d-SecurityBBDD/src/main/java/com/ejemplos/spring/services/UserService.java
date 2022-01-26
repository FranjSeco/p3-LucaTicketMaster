package com.ejemplos.spring.services;

import com.ejemplos.spring.model.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public void saveUser(User user);
}