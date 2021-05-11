package com.ticket.booking.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.dao.TicketBookingDao;
import com.ticket.booking.domain.Ticket;

@Service
public class TicketService {
	
	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
		//insert into ticket values('','','');
	}
	
	public Iterable<Ticket> getAllTickets(){
		return ticketBookingDao.findAll();
		//select * from ticket;
	}
	
	public Optional<Ticket> getTicket(Integer ticketId) {
		 return ticketBookingDao.findById(ticketId);
		 
		 //select * from ticket where ticket_id=ticketId
	}
	
	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
		//delete ticket where ticket_id=ticketId
	}
	
	public Ticket updateTicket(Integer ticketId,String newEmail) {
		
		Ticket ticket=ticketBookingDao.findById(ticketId)
				.orElse(new Ticket());
		ticket.setEmail(newEmail);
		
		return ticketBookingDao.save(ticket);
		
		//update ticket set email=<newemail> where ticket_id=ticketId
		
		
		
	}
	
	
	
	
	
	

}
