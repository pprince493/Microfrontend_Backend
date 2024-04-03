package com.nagarro.postalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PostalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostalServiceApplication.class, args);
	}

}
