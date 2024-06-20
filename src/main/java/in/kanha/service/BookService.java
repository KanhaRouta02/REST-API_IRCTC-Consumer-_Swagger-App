package in.kanha.service;

import org.springframework.stereotype.Service;

import in.kanha.request.Passenger;
import in.kanha.response.Ticket;

@Service
public interface BookService {

	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNumber);
}
