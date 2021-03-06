package com.danielsg.drugs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DrugsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugsApplication.class, args);
	}

}
