package com.ejemplos.spring.repository;

import java.util.ArrayList;

//METODOS
/**
* findAll	Returns a Collection of all the students in the Map
* findById	Searches the Map for a student with the specified ID. If found, the student is returned.
* save	    Assigns the student an ID and saves the student in the Map.
* update	Replaces the student in the Map if it exists.
* delete	Deletes the student in the Map if it exists.
*/


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Student;


@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private Map<Long, Student> students = new HashMap<>();

	/*
	 * Typically, the database will assign the unique id (or primary key) when
	 * adding an entity. Since we are using an in-memory Map, we must explicitly
	 * assign the student id in the repository class. Allowing the client to assign
	 * the unique id is not RESTful.
	 */
	private long currentID = 100;
	
	// Ojo. Esto es solo para hacer una prueba
	public void datosPrueba() {
		students.put(++currentID, new Student(currentID, "Antonio", "Santos", "master"));
		students.put(++currentID, new Student(currentID, "Luis", "Sanz", "lechon"));
		students.put(++currentID, new Student(currentID, "Maria", "Gómez", "junior"));
	}
	
	public StudentRepositoryImpl() {
		super();
		// Ojo. esto solo para pruebas
		this.datosPrueba();
	}

	// Return all students
	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<>(students.values());
		return list;
	}
	
	
	// Find the student with this id
	/*
	 * We are using java.util.Optional as a container for our Student object as it
	 * will help us handle cases where Student is null. This is purely an
	 * implementation decision and has nothing to do with REST concepts or
	 * constraints.
	 */
	public Optional<Student> findById(Long id) {
		System.out.println("-------- findById ");
		Student student = null;

		if (students.containsKey(id)) {
			student = students.get(id);
		}
		return Optional.ofNullable(student);
	}
	

	// Save a new student
	public Student save(Student student) {
		student.setId(++currentID);
		students.put(student.getId(), student);
		return student;
	}

	// Update the student with this id
	public Optional<Student> update(Student student) {
		Student currentStudent = students.get(student.getId());

		if (currentStudent != null) {
			students.put(student.getId(), student);
			currentStudent = students.get(student.getId());
		}
		return Optional.ofNullable(currentStudent);
	}
	

	// Delete student with this id
	public void deleteById(Long id) {
		Student currentStudent = students.get(id);
		System.out.println("------ "+currentStudent);

		if (currentStudent != null) {
			students.remove(id);
		};
		System.out.println("------ "+students);
	}


}
