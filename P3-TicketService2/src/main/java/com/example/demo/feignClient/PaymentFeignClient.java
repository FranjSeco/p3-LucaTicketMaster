package com.example.demo.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.response.PaymentResponse;

@FeignClient(name = "paymentService", url= "http://localhost:9999")
public interface PaymentFeignClient {
	 @GetMapping("/payment/{eventName}/{eventPrice}")
	  PaymentResponse processPayment (@PathVariable String eventName, @PathVariable String eventPrice);
}
