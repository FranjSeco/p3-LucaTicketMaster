package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.User;
import com.ejemplos.spring.services.UserService;
@RequestMapping(value="/users")
@RestController
public class HomeController {

	private UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/findall")
	public List<User> GetUsers(){
		return userService.findAll();
	}

	@PostMapping(value = "/register")
	public User createNewUser(@RequestBody User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			return null;
		} else {
			return userService.saveUser(user);
		}
	}



}