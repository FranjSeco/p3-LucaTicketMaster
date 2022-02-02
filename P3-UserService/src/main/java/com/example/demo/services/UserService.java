package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.model.User;
import com.example.demo.response.UserResponse;

public interface UserService {
	//Show all users
	public List<UserResponse> findAll();
	
	public Optional<UserResponse> findById(Long id);
	
	public UserResponse findUserByUsername(String username);
	
	public UserResponse findUserByEmail(String email);
	
	public UserResponse findByUsernameAndPassword(String username, String password);
	
	public UserResponse saveUser(@Valid User user);
	
	public UserResponse getDetails(String name);
	
	public UserResponse deleteUser(String username) ;
	
	public UserResponse findByIdAndUpdate(String username, User user);


	

}
