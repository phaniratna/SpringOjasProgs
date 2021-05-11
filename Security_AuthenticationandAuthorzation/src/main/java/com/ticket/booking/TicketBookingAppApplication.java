package com.ticket.booking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ticket.booking.domain.Ticket;
import com.ticket.booking.service.TicketService;

@SpringBootApplication
public class TicketBookingAppApplication 
implements CommandLineRunner{

	@Autowired
	private TicketService service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Ticket ticket=new Ticket();
		ticket.setPassengerName("SunilJoshi");
		ticket.setEmail("joshi@gmail.com");
		ticket.setSourceStation("DELHI");
		ticket.setDestinationStation("HYDERABAD");
		ticket.setBookingDate(new Date());
		//service.createTicket(ticket);
		
		Ticket ticket2=new Ticket();
		ticket2.setPassengerName("Arun");
		ticket2.setEmail("arun@gmail.com");
		ticket2.setSourceStation("Hyderabad");
		ticket2.setDestinationStation("Goa");
		ticket2.setBookingDate(new Date());
		//service.createTicket(ticket2);
    
		
	}

}
