package com.example.demo.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import com.example.demo.security.TipoPasswordEncoder;
import com.example.demo.model.Role;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	//lame|hash
	@Qualifier("lame")
	private TipoPasswordEncoder encoder;
	
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public User findUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public User saveUser(User user) {
		System.out.println("---- Pwd: " + encoder.encode(user.getPassword()));
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		System.out.println("User is ready: " + user);
		//userRepository.save(user);
		return userRepository.save(user);
	}
	
	

}