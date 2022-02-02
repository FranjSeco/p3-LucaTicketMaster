package com.example.demo.cucumber;

import io.cucumber.java.PendingException;
import static org.hamcrest.MatcherAssert.assertThat;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.demo.model.PaymentModel;
import com.example.demo.response.PaymentResponse;
import com.example.demo.service.PaymentService;
import com.example.demo.service.PaymentServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PaymentServiceStepDefinitions {
	
	private PaymentService paymentService;
	private PaymentModel paymentModel;
	
	@Given("Una información de pago")
	  public void paymentInformationCreated() throws Throwable {
		  System.out.println("-----------------Detecta el Given");
		  paymentService = new PaymentServiceImpl();
		  paymentModel= new PaymentModel();
	  }

	 @When("Se envía la información con {int}")
	  public void testPayment(int code) throws Throwable {
		 System.out.println("-----------------Detecta el When");
		 paymentModel=paymentService.processPayment( code);
	  }
	  
	 @Then("Se obtiene un mensaje {string}")
	  public void testPaymentMessage(String msg) throws Throwable {
		 System.out.println("-----------------Detecta el THEN de MSG");
		  assertThat(paymentModel.getPaymentMsg(),is(msg));
	  }
	  
	 @Then("Se obtiene un código {int}")
	  public void testPaymentCOde(int code) throws Throwable {
		 System.out.println("-----------------Detecta el THEN de CODE");
		  assertThat(Integer.parseInt(paymentModel.getPaymentCode()),is(code));
		  
	  }


}
