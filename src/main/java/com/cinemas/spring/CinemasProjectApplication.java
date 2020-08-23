package com.cinemas.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cinemas.spring.repositories.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CinemasProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemasProjectApplication.class, args);
	}

}
