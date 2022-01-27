<<<<<<< HEAD
package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findAll();
	public User findByUsername(String username);
	public User findByEmail(String email);
	public List<User> findByUsernameAndPassword(String username, String password);
=======
package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findAll();
	public User findByUsername(String username);
	public User findByEmail(String email);
	public List<User> findByUsernameAndPassword(String username, String password);
>>>>>>> 1a358005aa76882c22b3c6ccafde611b89e267e3
}