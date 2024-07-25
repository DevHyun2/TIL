package com.shinhan.firstzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FirstzoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstzoneApplication.class, args);
	}

}
