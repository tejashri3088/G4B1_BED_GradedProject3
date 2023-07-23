package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.Ticket;
import com.greatlearning.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@GetMapping("/list")
	public String listTickets(Model theModel) {
		List<Ticket> tickets = ticketService.findAll();
		theModel.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Ticket ticket = new Ticket();
		String heading = "Create Ticket";
		model.addAttribute("ticket", ticket);
		model.addAttribute("heading", heading);
		return "tickets/ticket-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId") int id,
									Model model) {
		Ticket ticket = ticketService.findById(id);
		String heading = "Edit Ticket";
		model.addAttribute("ticket", ticket);
		model.addAttribute("heading", heading);
		return "tickets/ticket-form";			
	}
	
	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.save(ticket);
		return "redirect:/tickets/list";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("ticketId") int id) {
		ticketService.deleteById(id);
		return "redirect:/tickets/list";
	}
	
	@PostMapping("/search")
	public String searchTicket(@RequestParam("searchParameter") String searchParameter, Model theModel) {
		List<Ticket> tickets = ticketService.findBySearchParameter(searchParameter, searchParameter);
		theModel.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}
	
	@PostMapping("/view")
	public String view(@RequestParam("ticketId") int id, Model model) {
		Ticket ticket = ticketService.findById(id);
		model.addAttribute("ticket",ticket);
		return "tickets/view";
	}
}
