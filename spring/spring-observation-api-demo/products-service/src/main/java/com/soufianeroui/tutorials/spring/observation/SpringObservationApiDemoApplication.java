package com.soufianeroui.tutorials.spring.observation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringObservationApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringObservationApiDemoApplication.class, args);
	}
}
