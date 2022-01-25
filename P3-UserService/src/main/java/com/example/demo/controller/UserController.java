package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String loginUser() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping(value = "/register")
	public String addUser(User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			model.addAttribute("message", "Username already registered");
			return "register";
		} else {
			userService.saveUser(user);
			model.addAttribute("message", "Successful registration. Please login");
			return "login";
		}
	}
	
	
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}	
	

}
