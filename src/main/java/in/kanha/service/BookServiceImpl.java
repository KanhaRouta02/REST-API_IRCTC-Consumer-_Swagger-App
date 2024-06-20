package in.kanha.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.kanha.request.Passenger;
import in.kanha.response.Ticket;

@Service
public class BookServiceImpl implements BookService{

	private Map<Integer, Ticket> map = new HashMap<>();
	private Integer ticketNumber= 1;
	@Override
	public Ticket bookTicket(Passenger passenger) {
		//logic 
	    Ticket t = new Ticket();	
	    BeanUtils.copyProperties(passenger, t);
	    t.setPrice(500.00);
	    t.setStatus("CONFIRMED");
	    t.setTicketNumber(ticketNumber);
	    map.put(ticketNumber, t);
	    ticketNumber++;
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		
		if(map.containsKey(ticketNumber))
		{
			Ticket ticket = map.get(ticketNumber);
			return ticket;
		}
		return null;
	}

}
