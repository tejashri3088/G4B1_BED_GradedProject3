package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Ticket;

public interface TicketService {
	
	public void save(Ticket ticket);
	
	public Ticket findById(int id);
	
	public List<Ticket> findAll();
	
	public void deleteById(int id);
	
	public List<Ticket> findBySearchParameter(String title, String description);
	
}
