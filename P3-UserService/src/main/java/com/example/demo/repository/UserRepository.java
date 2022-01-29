package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	public List<User> findAll();
	public User findByUsername(String username);
	public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE username = ?1 AND password = ?2")
	public User findByUsernameAndPassword(String username, String password);
	
	
}