package com.example.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.error.EmailAlreadyExistsException;
import com.example.demo.controller.error.IncorrectPasswordException;
import com.example.demo.controller.error.UserAlreadyExistsException;
import com.example.demo.controller.error.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.UserResponse;
import com.example.demo.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@RequestMapping("/users")
@Tag(name = "users", description = "Users API")
public class UserController {
	
	//DOC añadido logger(seguimiento de los errores en cada class --> historial)
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//Para ver el listado completo de usuarios
	@Operation(summary = "Buscar todos los usuarios", description = "Cuando se hace la petición se devuelve una List<UserResponse>", tags= {"user"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
	
	@GetMapping("/findall")
	public List<UserResponse> GetUsers(){
		logger.info("Se accede a lista");
		return userService.findAll();
	}
	
	
	
	//Conexion con user feign para buscar por nombre
	@Operation(summary = "Buscar usuarios por nombre", description = "Dado un nombre devuelve un objeto UserResponse", tags= {"user"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
		@GetMapping("/{name}")
	   public UserResponse getDetails(@Parameter(description = "Name del user a localizar", required=true)
	   @PathVariable String name) {
		   logger.info("------GetDetails (GET) ");
		   UserResponse e= userService.getDetails(name);
		   if (e == null){
			   throw new UserNotFoundException(name);
		   }
		   return e;
	   }
	
	
	//Entrar a la página
	@Operation(summary = "Acceder con username y password", description = "Dado un username y un password devuelve el objeto User autorizado", tags= {"user"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario autorizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
	@PostMapping(value="/login")
	
    public UserResponse loginUser(@Parameter(description = "Nombre y contraseña del usuario que se va a loggear", required=true)
    		@Valid @RequestBody User user, BindingResult bindingResult, Model model)  {
		
		UserResponse userExists = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		UserResponse userCheck = userService.findUserByUsername(user.getUsername());
        //User userBack = userService.userBack(userExists);
		//UserResponse checkUser = userService.getDetails(user.getUsername());
        if (userExists != null) {
            logger.info("------ login  ");
            return userExists;
        } 
       // throw new UserNotFoundException();
        
        else {
        	
	        if (userCheck != null) {
	 
	            	throw new IncorrectPasswordException(user.getUsername());
	            	}
	            
	         throw new UserNotFoundException();
	       } 
       
           
        
    }
	
	

	//Email único
	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) != null;
	}
		
	//Registrar un nuevo usuario
	@Operation(summary = "Registrar un nuevo usuario", description = "Dado un UserResponse se añade a la base de datos de usuarios", tags= {"user"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario creado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
	
	@PostMapping(value = "/register")
	public UserResponse addUser(@Parameter(description = "Nombre del usuario a registrar", required=true)
			@Valid @RequestBody User user, BindingResult bindingResult, Model model) {
		UserResponse userExists = userService.findUserByUsername(user.getUsername());
		
		
		if (userExists != null) {
			logger.info("------ usuario ya existente ");
			throw new UserAlreadyExistsException(user.getUsername());
			
		} if (emailExists(user.getEmail())) {
			throw new EmailAlreadyExistsException(user.getEmail());
			
		
		} else {
			logger.info("------ addUser (POST)");
			UserResponse result = userService.saveUser(user);
			logger.info("------ Dato Salvado " + result);
			return result;
		}
	}
	
	
	//Eliminar un usuario de la DB
	@Operation(summary = "Eliminar un usuario por username", description = "Dado un username elimina el objeto UserResponse correspondiente", tags= {"user"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario eliminado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
	
	@DeleteMapping("/{username}")
	public UserResponse deleteUser(@Parameter(description = "Name del usuario a borrar", required=true)
			@PathVariable String username) {
		 logger.info("-----------deleteEvent  (DELETE)");
		UserResponse u = userService.getDetails(username);
		if (u == null) {
			throw new UserNotFoundException(username);
		}
		userService.deleteUser(username);
		return u;
				
	}
	
	@Operation(summary = "Modificar usuarios encontrados por username", description = "Dado un username permite modificar la información de dicho usuario", tags= {"user"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario actualizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
	
	@PutMapping("/{username}")
	public UserResponse modifyUser(@Parameter(description = "Name del usuario a modificar", required=true)		
	 @PathVariable String username, @RequestBody User user) {
		logger.info("---------modifyUser (PUT)");
		UserResponse checkUser = userService.getDetails(username);

				
		if (checkUser == null) {
			throw new UserNotFoundException(username);
		}
		
		
		return userService.findByIdAndUpdate(username, user);
	}
	
	
	/*
	@Operation(summary = "Buscar usuarios por ID", description = "Dado un ID, devuelve un objeto User", tags= {"user"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado (NO implementado)", content = @Content) })
	
	//Registrar nuevos usuarios
	@GetMapping("/{id}")
	
	public UserResponse GetUsers(
			@Parameter(description = "ID del user a localizar", required=true) 
			@PathVariable Long id) {			
		logger.info("------GetUsers (GET) ");
		
		return userService.findById(id).orElseThrow(UserNotFoundException::new);
	}
	
	*/
	
	

}

