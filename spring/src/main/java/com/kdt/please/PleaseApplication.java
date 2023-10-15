package com.kdt.please;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PleaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PleaseApplication.class, args);
	}

}
