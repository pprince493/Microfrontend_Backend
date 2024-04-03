package com.nagarro.microfrontend.loanoffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoanOffersApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanOffersApplication.class, args);
	}

}
