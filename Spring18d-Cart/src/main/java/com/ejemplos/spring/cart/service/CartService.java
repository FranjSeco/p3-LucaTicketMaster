package com.ejemplos.spring.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.cart.model.Cart;
import com.ejemplos.spring.cart.model.CartProduct;
import com.ejemplos.spring.cart.repository.CartProductRepository;
import com.ejemplos.spring.cart.repository.service.CartRepository;
import com.ejemplos.spring.cart.response.ProductResponse;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartProductRepository cartProductRepository;

	@Autowired
	private RestTemplate restTemplate;

	public void addProduct(Long id, Long idProduct, Integer qt) {
        // rest template a pelo
        //final ProductResponse product = restTemplate.getForObject("http://localhost:7777/product/" + idProduct, ProductResponse.class);
		
		// hemos llamado al microservicio
		// Realmente hay 2 maneras de comunicar microservicios. Una de ellas es con
		// REStTemplate y la otra con cliente feign
		final ProductResponse product = restTemplate.getForObject("http://catalog/product/" + idProduct,ProductResponse.class);
		//Tb podria haber convertido el productResponse a Product y pasarlo ahora como argumento
		this.addProduct(id, idProduct, product.getPrice(), product.getName(), qt);

	}

	public void addProduct(Long id, Long idProduct, BigDecimal price, String name, Integer qt) {
		final Cart cart = cartRepository.findById(id).orElseThrow();

		for (int i = 0; i < qt; i++) {
			CartProduct cp = new CartProduct();
			cp.setCart(cart);
			cp.setProduct_id(idProduct);
			cp.setPrice(price);
			cp.setName(name);
			cartProductRepository.save(cp);
		}

	}
}
