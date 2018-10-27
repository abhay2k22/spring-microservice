package com.example.minus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MinusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinusApplication.class, args);
	}
}
