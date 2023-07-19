package com.tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScheduleTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleTourApplication.class, args);
	}

}
