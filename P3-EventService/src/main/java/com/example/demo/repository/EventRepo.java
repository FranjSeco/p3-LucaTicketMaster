package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EventModel;

@Repository
public interface EventRepo extends MongoRepository<EventModel, String> {

	
    @Query("{name:'?0'}")
    EventModel findItemByName(String name);
    
    @Query(value="{genre:'?0'}", countName="{'name' : 1, 'date' : 1}")
    List<EventModel> findAll(String genre);
}
