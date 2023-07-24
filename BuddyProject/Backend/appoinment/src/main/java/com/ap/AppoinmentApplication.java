package com.ap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ap") 
public class AppoinmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppoinmentApplication.class, args);
	}

}
