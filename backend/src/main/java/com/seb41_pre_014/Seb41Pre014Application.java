package com.seb41_pre_014;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Seb41Pre014Application {
	public static void main(String[] args) {
		SpringApplication.run(Seb41Pre014Application.class, args);
	}

}
