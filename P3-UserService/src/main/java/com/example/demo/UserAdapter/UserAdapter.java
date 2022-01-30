package com.example.demo.UserAdapter;

import java.util.List;
import java.util.Optional;
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
		userResponse.setName(user.getName());
		userResponse.setLastname(user.getLastname());
		userResponse.setEmail(user.getEmail());
		userResponse.setPassword(user.getPassword());
		userResponse.setDate(user.getDate());
		
		return userResponse;
	}
	public List<UserResponse> of(List<User> users) {
		return users.stream()
				.map(p -> of(p))
				.collect(Collectors.toList());
	}
	public Optional<UserResponse> of(Optional<User> usersId) {
		return usersId.stream()
				.map(p -> of(p))
				.findAny();
	}
	
}
