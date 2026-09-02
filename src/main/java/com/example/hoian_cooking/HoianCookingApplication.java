package com.example.hoian_cooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HoianCookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoianCookingApplication.class, args);
	}

}
