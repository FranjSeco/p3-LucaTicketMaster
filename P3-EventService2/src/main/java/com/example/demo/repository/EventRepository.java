package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EventModel;

@Repository
public interface EventRepository extends MongoRepository<EventModel, String> {
	
	// Find by name
	@Query("{name:'?0'}")
	EventModel findByName(String name);
	
	@Query("{location: '?0'}")
	List <EventModel> findByLocation(String location);
}