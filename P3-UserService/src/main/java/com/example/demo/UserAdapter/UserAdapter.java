package com.example.demo.UserAdapter;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.response.UserResponse;

@Component
public class UserAdapter {

	public UserResponse of (User user) {
		UserResponse userResponse =new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setUsername(user.getUsername());
		userResponse.setName(user.getName());
		userResponse.setLastname(user.getLastname());
		userResponse.setEmail(user.getEmail());
		userResponse.setPassword(user.getPassword());
		userResponse.setDate(user.getDate());
		
		return userResponse;
	}
	
}
