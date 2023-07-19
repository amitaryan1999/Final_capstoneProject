package com.rest.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class AgentDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentDetailsApplication.class, args);
	}

}
