package com.example.demo.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;


	
	@GetMapping
	public Collection<User> readUsers(){
		return userService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user){
		User result = this.userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		
		
		return ResponseEntity.created(location).build();
	}



	
	

	

}
/*public UserController(UserService userService) {
this.userService = userService;
}*/
/*@GetMapping("/login")
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

*	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}	
*
*/