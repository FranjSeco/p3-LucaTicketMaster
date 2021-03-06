package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.feignClient.PaymentFeignClient;


@SpringBootTest
public class shouldConnectToPaymentMicroservice {
	//Given
	@Autowired
	PaymentFeignClient paymentFeign;
	
	@Test
	void contextLoads() {
		
		// When
		assertThat(paymentFeign.processPayment("holabebe", "holabebe2"))
		// Then
		.isNotNull();
		
	}
}
