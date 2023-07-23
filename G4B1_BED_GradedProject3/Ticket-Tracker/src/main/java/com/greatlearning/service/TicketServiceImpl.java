package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.TicketRepository;
import com.greatlearning.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(int id) {
		Optional<Ticket> result = ticketRepository.findById(id);
		Ticket ticket = null;
		if (result.isPresent()) {
			ticket = result.get();
		} else {
			throw new RuntimeException("Did not find ticket with id - " + id);
		}
		return ticket;
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public List<Ticket> findBySearchParameter(String title, String description) {
		return ticketRepository.findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(title,description);
	}

}
