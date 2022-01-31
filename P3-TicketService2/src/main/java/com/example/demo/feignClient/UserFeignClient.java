package com.example.demo.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.response.UserResponse;

@FeignClient(name = "userService", url= "http://localhost:8888")
public interface UserFeignClient {
	 @GetMapping("/users/{name}")
	  UserResponse getDetails (@PathVariable String name);

}
