package com.example.demo.cucumber.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class paymentService {
  @Given("Una información de pago")
  public void paymentHasBeenSuccesful() throws Throwable {
	  System.out.println("-----------------Detecta el Given");
  }

  @When("Se procesa la información")
  public void when() throws Throwable {
  }
  
  @And("Se obtiene un mensaje \"Todo correcto\"")
  public void and() throws Throwable {
  }
  
  @Then("Se obtiene un código del 0 al 6")
  public void then() throws Throwable {
  }

}
