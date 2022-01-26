package com.ejemplos.spring.catalog.product.adapter;

import org.springframework.stereotype.Component;

import com.ejemplos.spring.catalog.product.model.Product;
import com.ejemplos.spring.catalog.product.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

/*
 * La utilizo para convertir de entity a DTO
 */
@Component
public class ProductAdapter {

    public ProductResponse of(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setPrice(product.getPrice());
        productResponse.setName(product.getName());
        return productResponse;
    }

    public List<ProductResponse> of(List<Product> products) {
        return products.stream()
                .map(p -> of(p))
                .collect(Collectors.toList());
    }
}
