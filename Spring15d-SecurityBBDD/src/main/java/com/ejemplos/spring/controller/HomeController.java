package com.ejemplos.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ejemplos.spring.model.User;
import com.ejemplos.spring.services.UserService;

@Controller
public class HomeController {

	private UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String rootPage() {
		return "public";
	}
	

	@GetMapping("/public")
	public String publicPage() {
		return "public";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping(value = "/register")
	public void  createNewUser(@RequestBody User user) {
		/*User userExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			model.addAttribute("message", "Username already registered");
			return "register";
		} else {
			userService.saveUser(user);
			model.addAttribute("message", "Successful registration. Please login");
			return "login";
		}*/
		userService.saveUser(user);
		
	}

	@GetMapping("/protected")
	public String protectedPage() {
		return "protected";
	}

	@GetMapping("/admin")
	public String adminPage() {
		return "admin/home";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}	

}