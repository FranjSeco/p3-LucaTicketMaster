package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ForceErrorRestController {
	//Es un error normal y corriente. No mapeado
	@GetMapping(value = "/users/throwException")
    public void throwException() {
        throw new IllegalArgumentException("\"I am the error message from Rest Controller\"");
    }

}
