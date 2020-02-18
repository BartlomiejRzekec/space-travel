package com.example;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpaceTravelsApplication {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(SpaceTravelsApplication.class, args);
		
	}

}
