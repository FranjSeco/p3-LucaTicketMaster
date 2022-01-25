package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.repository.EventRepository;


@SpringBootApplication
@EnableMongoRepositories
public class P3EventServiceApplication implements CommandLineRunner{

    @Autowired
    EventRepository eventItemRepo;
    
	public static void main(String[] args) {
		SpringApplication.run(P3EventServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
