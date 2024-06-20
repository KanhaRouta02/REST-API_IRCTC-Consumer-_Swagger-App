package in.kanha.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.kanha.request.Passenger;
import in.kanha.response.Ticket;
import in.kanha.service.BookServiceImpl;

@RestController
public class BookRestController {

	@Autowired
	private BookServiceImpl bookserviceImpl;
	
	@PostMapping("/book")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger)
	{
		Ticket ticket = bookserviceImpl.bookTicket(passenger);
		if(ticket == null)
		{
			return null;
		}
		return new ResponseEntity<Ticket>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping("ticket{ticketNumber}")
	public Ticket getTicket( @PathVariable Integer ticketNumber)
	{
		Ticket ticket = bookserviceImpl.getTicket(ticketNumber);
		return ticket;
	}
}
