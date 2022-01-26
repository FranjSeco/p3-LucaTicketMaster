package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Student;
import com.ejemplos.spring.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService  {
	
	@Autowired
	private StudentRepository repo;

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Student> findById(long id) {
		return repo.findById(id);
	}

	@Override
	public Student save(Student student) {
		return repo.save(student);
	}
	
	// EN SpringJPA no hay metodo Update
	@Override
	public Optional<Student> update(Student student) {
		return repo.update(student);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
