package com.example.demo.cucumber;

import com.example.demo.P3PaymentServiceApplication;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

/**
 * Class to use spring application context while running cucumber
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
@ContextConfiguration(classes = P3PaymentServiceApplication.class, loader = SpringBootContextLoader.class)
public class PaymentServiceCucumberContextConfiguration {

  private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceCucumberContextConfiguration.class);

  /**
   * Need this method so the cucumber will recognize this class as glue and load spring context configuration
   */
  @Before
  public void setUp() {
    LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
  }

}
