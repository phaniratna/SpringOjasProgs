package com.ticket.booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.domain.Ticket;
import com.ticket.booking.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	
	//Getting all Tickets
	@GetMapping("/admin/getAllTickets") //@Get + @RequestMapping
	public Iterable<Ticket> getAllTickets() {
		return service.getAllTickets();
	}

	
	
	
	//Get a Ticket
	
	@GetMapping("/ticket/{ticketId}")
	public Optional<Ticket> getTicket(
			@PathVariable("ticketId") Integer ticketId ) {
		return service.getTicket(ticketId);
	}
	
	
	

	
	
	
	
	
	
}
