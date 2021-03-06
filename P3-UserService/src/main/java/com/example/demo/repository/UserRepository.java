package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.response.UserResponse;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	public List<User> findAll();
	
	public Optional<User> findById(Long id);
	
	@Query("SELECT u FROM User u WHERE username = ?1")
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE username = ?1 AND password = ?2")
	public User findByUsernameAndPassword(String username, String password);
	


	

}