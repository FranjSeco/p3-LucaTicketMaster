package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;
import com.example.demo.response.UserResponse;

public interface UserService {
	//Show all users
	public List<User> findAll();
	
	public Optional<User> findById(long id);
	
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public User saveUser(User user);
	public User findByUsernameAndPassword(String username, String password);
	
	public User deleteUser(String username) ;

	

}
