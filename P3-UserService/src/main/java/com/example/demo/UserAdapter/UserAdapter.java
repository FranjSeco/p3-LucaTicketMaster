package com.example.demo.UserAdapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


import com.example.demo.model.User;
import com.example.demo.response.UserResponse;

@Component
public class UserAdapter {

	public UserResponse of (User user) {
		UserResponse userResponse =new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setUsername(user.getUsername());
		userResponse.setUserlastname(user.getUserlastname());
		userResponse.setEmail(user.getEmail());
		userResponse.setPassword(user.getPassword());
		userResponse.setDate(user.getDate());
		
		return userResponse;
	}
	
}
