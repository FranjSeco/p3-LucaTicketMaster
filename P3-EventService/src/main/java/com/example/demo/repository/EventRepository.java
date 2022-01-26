package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EventModel;

@Repository
public interface EventRepository extends MongoRepository<EventModel, String> {

	/*
    @Query("{'name': ?0}")
    EventModel findItemByName(String name);
    
    @Query(value="{'genre': ?0}", fields="{'name' : 1, 'date' : 1}")
    List<EventModel> findByGenre(String genre);
*/
    

}
