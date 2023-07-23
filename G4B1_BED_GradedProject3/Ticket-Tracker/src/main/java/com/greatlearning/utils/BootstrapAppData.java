package com.greatlearning.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.github.javafaker.Faker;
import com.greatlearning.dao.TicketRepository;
import com.greatlearning.entity.Ticket;

@Configuration
public class BootstrapAppData {

	@Autowired
	TicketRepository ticketRepository;
	
	private Faker faker = new Faker();
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationready(ApplicationReadyEvent event) {
		
		for (int i = 0; i < 5; i++) {
			Ticket ticket = new Ticket();

			ticket.setTitle(faker.rockBand().name());
			ticket.setDescription(faker.artist().name());
			ticket.setContent(faker.avatar().image());

			this.ticketRepository.saveAndFlush(ticket);
		}
		
	}
}
