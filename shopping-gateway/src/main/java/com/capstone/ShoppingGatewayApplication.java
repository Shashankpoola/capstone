package com.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingGatewayApplication.class, args);
	}

}
