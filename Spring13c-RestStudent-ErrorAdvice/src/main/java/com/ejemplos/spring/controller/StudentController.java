package com.ejemplos.spring.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ejemplos.spring.controller.error.StudentNotFoundException;
import com.ejemplos.spring.model.Student;
import com.ejemplos.spring.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@RequestMapping("/students")
@Tag(name = "student", description = "the Student API")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService serv;

	@GetMapping
	// @RequestMapping(method = RequestMethod.GET)
	public Collection<Student> readStudents() {
		return serv.findAll();
	}

	/*
	 * this orElseThrow method at the end of the findById call and what does it do?
	 * It is part of the java.util.Optional API. It returns the wrapped Student
	 * object if present, otherwise it throws the exception provided by the
	 * exception supplier. However, we can substitute the supplier with a method
	 * reference to our custom exception class’ constructor. When this exception is
	 * thrown, a “404 Not Found” status code is returned, as described above.
	 * https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html#orElseThrow
	 * -java.util.function.Supplier-.
	 */

	@Operation(summary = "Buscar estudiantes por ID", description = "Dado un ID, devuelve un objeto Student", tags= {"student"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Estudiante localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Studiante no encontrado (NO implementado)", content = @Content) })
	@GetMapping("/{id}")
	public Student readStudent(
			@Parameter(description = "ID del estudiante a localizar", required=true) 
			@PathVariable Long id) {			
		logger.info("------ readStudent (GET) ");
		return serv.findById(id).orElseThrow(StudentNotFoundException::new);
	}

	// @RequestBody Student student significa que un estudiante será el cuerpo de la
	// respuesta
	// Devuelve en la cabecera la URL
	// Añado ahora la validacion
	@PostMapping
	public ResponseEntity<?> addStudent(@Valid @RequestBody Student student) {
		// Si hubiera habido algun error, hubier saltado una excecpcion anytes de entrar
		// Y como las capturo con CustonGlobalException, no pasa por aqui
		logger.info("------ addStudent (POST)");
		Student result = this.serv.save(student);
		logger.info("------ Dato Salvado " + result);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();

		/*
		 * Inside the method body, we build a java.net.URI object using
		 * ServletUriComponentsBuilder. It builds the object by capturing the URI of the
		 * current request and appending the placeholder /{id} to create a template.
		 * buildAndExpand(result.getId()) inserts the id of the newly created student
		 * into the template. The result is the URI of the new resource.
		 */

		// Nosotros podemos devolver 2 cosas siempre; o bien una URI o un recurso.
		// En este caso devolvemos la URI
		// Y marcamos de vuelta un 201
		return ResponseEntity.created(location).build();
	}

	/*
	 * @PostMapping public Student addStudent(@RequestBody Student student) { return
	 * serv.save(student); }
	 */

	// Actualizar un usuario
	@PutMapping
	public Student updateStudent(@RequestBody Student student) {
		logger.info("------ updateStudent (PUT)");
		return this.serv.update(student).orElseThrow(StudentNotFoundException::new);
	}

	// Una segunda forma no tan personalizada
	// @PutMapping
	public ResponseEntity<Student> updateStudent2(@RequestBody Student student) {
		Optional<Student> st = this.serv.update(student);
		if (st.isEmpty()) {
			// No encontrado
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.of(st);

	}

	// Borrar un usuario
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		serv.deleteById(id);
	}

}
