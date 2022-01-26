package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.EventModel;

@Repository
public interface EventDao extends MongoRepository<EventModel, String> {

	
    @Query("{'name': ?0}")
    EventModel findItemByName(String name);
    
    @Query(value="{'genre': ?0}", fields="{'name' : 1, 'date' : 1}")
    List<EventModel> findAll(String genre);
}
