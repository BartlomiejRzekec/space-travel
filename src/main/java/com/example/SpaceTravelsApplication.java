package com.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpaceTravelsApplication {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		ConfigurableApplicationContext run = SpringApplication.run(SpaceTravelsApplication.class, args);
		

	}
}
