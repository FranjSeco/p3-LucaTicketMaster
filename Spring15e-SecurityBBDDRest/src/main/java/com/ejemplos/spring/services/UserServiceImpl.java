package com.ejemplos.spring.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Role;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.RoleRepository;
import com.ejemplos.spring.repository.UserRepository;
import com.ejemplos.spring.security.TipoPasswordEncoder;

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

		Role userAdminRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userAdminRole)));

		System.out.println("User is ready: " + user);
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}