package com.example.demo.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.response.EventResponse;

@FeignClient(name = "eventService", url= "http://localhost:7777")
public interface EventFeignClient {
	 @GetMapping("/event/{name}")
	  EventResponse getDetails (@PathVariable String name);

}
