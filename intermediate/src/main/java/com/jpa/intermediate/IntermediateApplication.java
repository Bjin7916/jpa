package com.jpa.intermediate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IntermediateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntermediateApplication.class, args);
	}

}
