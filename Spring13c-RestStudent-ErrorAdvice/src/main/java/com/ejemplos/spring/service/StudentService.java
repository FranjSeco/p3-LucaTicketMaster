package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Student;

public interface StudentService {
	
	// Return all students
	public List<Student> findAll();
	
	// Find the student with this id
	public Optional<Student> findById(long id);

	// Save a new student & update
	public Student save(Student student);
	// EN SpringJPA no hay metodo Update
	public Optional<Student> update(Student student);

	// Delete student with this id
	public void deleteById(Long id);


}
