package com.example.demo.cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.core.cli.Main;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")

public class PaymentServiceTest {

}