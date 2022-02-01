package com.example.demo.feingClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@FeignClient(name = "ticketService", url= "http://localhost:5555")
public interface UserEventsFeingClient {
	 @GetMapping("/ticket/buyticket")
	  UserEventsResponse buyTicket (@PathVariable String name);
	
}
