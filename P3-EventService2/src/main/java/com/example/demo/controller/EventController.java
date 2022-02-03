package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.controller.error.EventAlreadyExistsException;
import com.example.demo.controller.error.EventIsIncompleteException;
import com.example.demo.controller.error.EventNotFoundException;
import com.example.demo.model.EventModel;
import com.example.demo.repository.EventRepository;
import com.example.demo.response.EventResponse;
import com.example.demo.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/events")
@Tag(name = "events", description = "Events API")
public class EventController {

   private static final Logger log = LoggerFactory.getLogger(EventController.class);

   @Autowired
   private EventService eventService;
   
   @Autowired
   private EventRepository eventRepository;
   
   @Operation(summary = "Buscar todos los eventos", description = "Cuando se hace la petición se devuelve una List<EventResponse> ", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista localizada", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Lista no encontrada (NO implementado)", content = @Content) })
  
   @GetMapping
   public List<EventResponse> getAll() {
	   log.info("Se accede al controllador");
	   return eventService.showAllEvents();
   }
   
   @Operation(summary = "Añadir nuevo evento", description = "Dado un EventResponse, se añade a la Base de Datos", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento añadido", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no añadido, ruta incorrecta (NO implementado)", content = @Content) })
  
   @PostMapping("/add")
   public ResponseEntity<?> addEvent(@Valid  @RequestBody EventModel event){
	   log.info("------ addStudent (POST)");
	   EventResponse check= eventService.getDetails(event.getName());
	   if(check != null){
		   throw new EventAlreadyExistsException(event.getName());
	   }
	   if (event.getName()==null||event.getDate()==null||event.getGenre()==null||event.getLocation()==null) {
		   throw new EventIsIncompleteException(event.getName(),event.getDate(),event.getLocation(),event.getGenre());
	   }
	   EventResponse evento= this.eventService.addEvent(event);
	   log.info("------ Dato Salvado " + evento);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(evento.getName())
				.toUri();
		return ResponseEntity.created(location).build();
	   
   }
   
   @Operation(summary = "Buscar eventos por nombre", description = "Dado un nombre devuelve un objeto EventResponse", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado (NO implementado)", content = @Content) })
   
   @GetMapping("/{name}")
   public EventResponse getDetails(@Parameter(description = "Name del event a localizar", required=true)
   @PathVariable String name) {
	   log.info("------GetDetails (GET) ");
	   EventResponse e= eventService.getDetails(name);
	   if (e == null){
		   throw new EventNotFoundException(name);
	   }
	   return e;
   }
   
   @Operation(summary = "Updatear eventos encontrados por nombre", description = "Dado un nombre permite modificar la información de dicho Evento", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento actualizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado (NO implementado)", content = @Content) })
  
   @PutMapping("/{name}")
   public EventResponse modifyEvent(@Parameter(description = "Name del event a modificar", required=true)
   @PathVariable String name, @RequestBody EventModel event) {
	   log.info("---------modifyEvent (PUT)");
	   EventResponse check=eventService.getDetails(name);
	   if (check == null){
		   throw new EventNotFoundException(name);
	   }
	   return eventService.findByIdAndUpdate(name, event);
   }
   
   @Operation(summary = "Eliminar eventos por nombre", description = "Dado un nombre elimina ese objeto EventResponse", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento eliminado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado (NO implementado)", content = @Content) })
  
   @DeleteMapping("/{name}")
   public EventResponse deleteEvent(@Parameter(description = "Name del event a borrar", required=true)
   @PathVariable String name) {
	   log.info("-----------deleteEvent  (DELETE)");
	   EventResponse e= eventService.getDetails(name);
	   if (e == null){
		   throw new EventNotFoundException(name);
	   }
	   eventService.deleteEvent(name);
	   return e;
   }
   
   @Operation(summary = "Filtrar eventos por nombre.", description = "Busqueda en la base de datos de eventos. Busca desde nombres que contengan una letra dada a nombres que coincidan totalmente con la palabra que queremos.", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busqueda realizada con exito.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Eventos no encontrado (NO implementado)", content = @Content) })
   
   @GetMapping("/name/{name}")
   public List<EventModel> findByName(@PathVariable(value = "name") String name) {
	   return eventRepository.findByGivenName(name);
   }
   
   @Operation(summary = "Filtrar eventos por localizacion.", description = "Busqueda en la base de datos de eventos. Busca desde localizaciones que contengan una letra dada a localizaciones que coincidan totalmente con la palabra que queremos.", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busqueda realizada con exito.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Eventos no encontrado (NO implementado)", content = @Content) })
   
   @GetMapping("/location/{location}")
   public List<EventModel> findByLocation(@PathVariable(value = "location") String location) {
	   return eventRepository.findByLocation(location);
   }
   
   @Operation(summary = "Filtrar eventos por genero musical.", description = "Busqueda en la base de datos de eventos. Busca desde generos que contengan una letra dada a generos que coincidan totalmente con la palabra que queremos.", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busqueda realizada con exito.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Petición no válida (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Eventos no encontrado (NO implementado)", content = @Content) })
   
   @GetMapping("/genre/{genre}")
   public List<EventModel> findByGenre(@PathVariable(value = "genre") String genre) {
	   return eventRepository.findByGenre(genre);
   }
}