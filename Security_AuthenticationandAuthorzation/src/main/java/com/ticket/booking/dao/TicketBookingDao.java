package com.ticket.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.booking.domain.Ticket;

@Repository
public interface TicketBookingDao 
extends JpaRepository<Ticket, Integer> {

}
