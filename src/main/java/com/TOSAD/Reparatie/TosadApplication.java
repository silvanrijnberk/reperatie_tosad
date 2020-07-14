package com.TOSAD.Reparatie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TosadApplication {

	public static void main(String[] args) {
		SpringApplication.run(TosadApplication.class, args);
	}

}
