package com.greatlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Ticket Tracker Application",contact=@Contact(email="admin@gmail.com")))
public class TicketTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerApplication.class, args);
	}

}
