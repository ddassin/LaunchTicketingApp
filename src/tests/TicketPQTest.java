package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Ticket;
import model.TicketPQ;

class TicketPQTest {
	
	Ticket newTicket1 = new Ticket("555", "Create this ticket", "I want to create a new ticket for another user", "Other", "Low", "Client", "Last", "client.last@gmail.com", LocalDate.now());

	TicketPQ newTicketPQ1 = new TicketPQ(); 
	
	@Test
	void testTicketPQ() {
		
		Ticket newTicket3 = new Ticket("363", "Create this ticket", "I want to create a new ticket for another user", "Other", "Low", "Client", "Last", "client.last@gmail.com", LocalDate.now());
					
		assertEquals("Ticket [ticketNum=363, ticketTitle=Create this ticket, description=I want to create a new ticket for another user, category=Other, priority=Low, clientFirstName=Client, clientLastName=Last, email=client.last@gmail.com, dateTicketCreated=2024-12-06] --- Priority Low", new TicketPQ(newTicket3, newTicket3.getPriority()) );
	}

	@Test
	void testTicketPQTicketString() {
		
		TicketPQ newTicketPQ4 = new TicketPQ(newTicket1, newTicket1.getPriority());		
		assertEquals("Ticket [ticketNum=555, ticketTitle=Create this ticket, description=I want to create a new ticket for another user, category=Other, priority=Low, clientFirstName=Client, clientLastName=Last, email=client.last@gmail.com, dateTicketCreated=2024-12-06] --- Priority Low" , newTicketPQ4.toString());
	}



	@Test
	void testCompareToTicketPQ() {
		
		Ticket newTicket5 = new Ticket("501", "Create this ticket", "I want to create a new ticket for another user", "Other", "Low", "Client", "Last", "client.last@gmail.com", LocalDate.now());
		newTicketPQ1.compareTo(newTicket5);
		assertFalse((newTicketPQ1.compareTo(newTicket5) > 0 ), "");
		assertEquals(0, newTicketPQ1.compareTo(newTicket5));
	}
	
	@Test
	void testgetPriorityValue() {
		
		Ticket newTicket8 = new Ticket("633", "Create this ticket", "I want to create a new ticket for another user", "Other", "High", "Client", "Last", "client.last@gmail.com", LocalDate.now());
		TicketPQ newTicketPQ88 =  new TicketPQ(newTicket8, newTicket8.getPriority());
		
		assertEquals("Low", newTicketPQ1.getTicketPriority());
		assertEquals("High", newTicketPQ88.getTicketPriority());
	}

}
