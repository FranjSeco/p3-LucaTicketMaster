package com.ejemplos.spring.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.cart.repository.service.CartRepository;
import com.ejemplos.spring.cart.response.CartResponse;
import com.ejemplos.spring.cart.response.ProductResponse;
import com.ejemplos.spring.cart.service.CartService;


import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired private CartRepository cartRepository;
    @Autowired private CartService cartService;

    @Autowired private RestTemplate restTemplate;
    
    @GetMapping("/")
    public List<CartResponse> getCartAll() {
        return CartResponse.of(cartRepository.findAll());
    }

    @GetMapping("/{id}")
    public CartResponse getCart(@PathVariable Long id) {
        return CartResponse.of(cartRepository.findById(id).orElseThrow());
    }

    //La llamaremos  
    //    /1/add?idProduct=2
    //    /1/add?idProduct=2&qt=8
    @PostMapping("/{id}/add")
    public void addProduct(@PathVariable Long id, @RequestParam Long idProduct, @RequestParam(defaultValue = "1") Integer qt) {
        cartService.addProduct(id, idProduct, qt);
    }
}
