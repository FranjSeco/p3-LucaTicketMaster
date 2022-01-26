package com.example.demo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//Para hacer pruebas desde el postman
	@GetMapping("/findall")
	public List<User> GetUsers(){
		return userService.findAll();
	}
	
	//Registrar nuevos usuarios
	@PostMapping(value = "/register")
	public User addUser(@RequestBody User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			return null;
		} else {
			return userService.saveUser(user);
		}
	}

	

}
