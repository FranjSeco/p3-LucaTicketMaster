package com.example.demo.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.UserAdapter.UserAdapter;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.EventResponse;
import com.example.demo.response.UserResponse;
import com.example.demo.security.TipoPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	UserAdapter userAdapter;
	
	@Autowired
	//lame|hash
	@Qualifier("lame")
	private TipoPasswordEncoder encoder;
	
	@Override
	public List<UserResponse> findAll() {
		return userAdapter.of(userRepository.findAll()); 
	}
	@Override
	public Optional<UserResponse> findById(Long id) {
		return userAdapter.of(userRepository.findById(id));
	}
	
	
	@Override
	public UserResponse findUserByUsername(String username) {
		if (userRepository.findByUsername(username)==null) {
			return null;
		}else {
		return userAdapter.of(userRepository.findByUsername(username)) ;
		}
	}
	@Override
	public UserResponse findUserByEmail(String email) {
		return userAdapter.of(userRepository.findByEmail(email));
		
	}
	@Override
	public UserResponse saveUser(User user) {
		System.out.println("---- Pwd: " + encoder.encode(user.getPassword()));
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		System.out.println("User is ready: " + user);
		
		return userAdapter.of(userRepository.save(user));
	}
	@Override
	public UserResponse findByUsernameAndPassword(String username, String password) {
		
		return userAdapter.of(userRepository.findByUsernameAndPassword(username, password));
	}
	
	
	@Override
	public UserResponse deleteUser(String username) {
		
		User userDelete = userRepository.findByUsername(username);
		
		userRepository.deleteById(userDelete.getId());
		
		return userAdapter.of(userDelete);
	}
	
	
	@Override
	public UserResponse getDetails(String name) {
		UserResponse event = null;
		try {
			 event = userAdapter.of(userRepository.findByUsername(name));
		} catch (Exception e) {
			System.out.println("Error: "+ e);
		}
		return event;
	}

	
	
	
	
}
