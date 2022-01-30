package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.error.EmailAlreadyExistsException;
import com.example.demo.controller.error.IncorrectPasswordException;
import com.example.demo.controller.error.UserAlreadyExistsException;
import com.example.demo.controller.error.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//doc añadido validated
@Validated
@RequestMapping(value="/users")
//doc añadido tag
@Tag(name = "users", description = "Users API")
public class UserController {
	
	//DOC añadido logger(seguimiento de los errores en cada class --> historial)
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//DOC añadido autowired
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
   // private AuthenticationManager authenticationManager;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//Para hacer pruebas desde el postman
	@GetMapping("/findall")
	public List<User> GetUsers(){
		return userService.findAll();
	}
	
	@Operation(summary = "Buscar usuarios por ID", description = "Dado un ID, devuelve un objeto User", tags= {"user"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
	//Registrar nuevos usuarios
	@GetMapping("/{id}")
	
	public User GetUsers(
			@Parameter(description = "ID del user a localizar", required=true) 
			@PathVariable Long id) {			
		logger.info("------GetUsers (GET) ");
		return userService.findById(id).orElseThrow(UserNotFoundException::new);
	}
	
	
	
	@PostMapping(value="/login")
    public User loginUser(@Valid @RequestBody User user, BindingResult bindingResult, Model model) {
        User userExists = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        //User userBack = userService.userBack(userExists);
        if (userExists != null) {
            logger.info("------ login  ");
            return userExists;
        } else {
           
            Optional<User> check =userService.findById(user.getId());
            if (check.get().getUsername()== null) {
            	throw new UserNotFoundException();
            }
            if (check.get().getPassword()!=user.getPassword()) {
            	
            	throw new IncorrectPasswordException(user.getUsername());
            }
            logger.info("------ no esta en la base : registrate");
            return null;
        }
    }
	
	//Email único
	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) != null;
	}
	
	
	
	
	@PostMapping(value = "/register")
	public User addUser(@Valid @RequestBody User user, BindingResult bindingResult, Model model) {
		User userExists = userService.findUserByUsername(user.getUsername());
		
		
		if (userExists != null) {
			logger.info("------ usuario ya existente ");
			throw new UserAlreadyExistsException(user.getUsername());
			
		} if (emailExists(user.getEmail())) {
			throw new EmailAlreadyExistsException(user.getEmail());
			
		
		} else {
			logger.info("------ addUser (POST)");
			User result = userService.saveUser(user);
			logger.info("------ Dato Salvado " + result);
			return result;
		}
	}

	
	@DeleteMapping("/{username}")
	public User deleteUser(@PathVariable String username) {
		
		userService.deleteUser(username);
		return null;
		
		
	}
	
	
	

}

