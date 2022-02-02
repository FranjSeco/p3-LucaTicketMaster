package com.example.demo.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.demo.response.PaymentResponse;
import com.example.demo.service.PaymentService;
import com.example.demo.service.PaymentServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentServiceStepDefinitions {
	
	private PaymentService paymentService;
	@Given("Una información de pago")
	  public void paymentHasBeenSuccesful() throws Throwable {
		  System.out.println("-----------------Detecta el Given");
		  paymentService = new PaymentServiceImpl();
	  }

	  @When("Se envía la información con {int} ")
	  public void testPayment(int code) throws Throwable {
		  paymentService.processPayment( code);
	  }
	  
	  @Then("Se obtiene un mensaje ")
	  public void and() throws Throwable {
	  }
	  
	  @Then("Se obtiene un código del 0 al 6")
	  public void then() throws Throwable {
		  
	  }


}
