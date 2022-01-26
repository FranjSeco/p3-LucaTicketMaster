package com.ejemplos.spring.catalog.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejemplos.spring.catalog.product.adapter.ProductAdapter;
import com.ejemplos.spring.catalog.product.model.Product;
import com.ejemplos.spring.catalog.product.repository.ProductRepository;
import com.ejemplos.spring.catalog.product.response.ProductResponse;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired 
    private ProductRepository productRepository;
    
    @Autowired 
    private ProductAdapter productAdapter;

    @GetMapping()
    public List<ProductResponse> list() {
        final List<Product> all = productRepository.findAll();
        return productAdapter.of(all);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {
        log.info("--- product por id "+id);
        final Product product = productRepository.findById(id).orElseThrow();
        return productAdapter.of(product);
    }
    
    //Sin probar
    @PostMapping()
    public ProductResponse addProduct(@RequestBody Product product) {
        final Product p = productRepository.save(product);
        return productAdapter.of(p);
    }
}
