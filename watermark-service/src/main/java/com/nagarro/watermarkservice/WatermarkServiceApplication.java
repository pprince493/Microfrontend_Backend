package com.nagarro.watermarkservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WatermarkServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatermarkServiceApplication.class, args);
	}

}
