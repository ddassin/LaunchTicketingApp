package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


import model.Ticket;

class TicketTest {
	
	
	Ticket newTicket1 = new Ticket("555", "Create this ticket", "I want to create a new ticket for another user", "Other", "Low", "Client", "Last", "client.last@gmail.com", LocalDate.now());


	@Test
	void testTicket() {
		Ticket newTicket2 = new Ticket();
			assertNull(null, newTicket2.getTicketNum());
			assertNull(null, newTicket2.getSubject());
			assertNull(null, newTicket2.getDescription());
			assertNull(null, newTicket2.getCategory());
			assertNull(null, newTicket2.getPriority());
			assertNull(null, newTicket2.getFirstName());
			assertNull(null, newTicket2.getLastName());
			assertNull(null, newTicket2.getEmail());
			assertEquals(LocalDate.now(), newTicket2.getDateTicketCreated());
	}

	
	@Test
	void testTicketStringStringStringStringStringStringStringStringLocalDate() {
		Ticket newTicket3 = new Ticket("546", "Create this ticket", "I want to create a new ticket for another user", "Other", "Low", "Client", "Last", "client.last@gmail.com", LocalDate.now());
		   assertEquals("546", newTicket3.getTicketNum());
		    assertEquals("Create this ticket", newTicket3.getSubject());
		    assertEquals("I want to create a new ticket for another user", newTicket3.getDescription());
		    assertEquals("Other", newTicket3.getCategory());
		    assertEquals("Low", newTicket3.getPriority());
		    assertEquals("Client", newTicket3.getFirstName());
		    assertEquals("Last", newTicket3.getLastName());
		    assertEquals("client.last@gmail.com", newTicket3.getEmail());
		    assertEquals(LocalDate.now(), newTicket3.getDateTicketCreated());
	}

	@Test
	void testGetTicketNum() {
		
		assertEquals("555", newTicket1.getTicketNum());
	}

	@Test
	void testSendTicketNumber() {
		assertEquals("555", newTicket1.getTicketNum());
	}

	@Test
	void testGetCategory() {
		assertEquals("Other", newTicket1.getCategory());
	}

	@Test
	void testGetPriority() {
		assertEquals("Low", newTicket1.getPriority());
	}

	@Test
	void testSetPriority() {
		
		newTicket1.setPriority("high");
				
		assertEquals("high", newTicket1.getPriority());
	}
	
	
	@Test
	void testToString() {
				
		assertEquals("Ticket [ticketNum=555, ticketTitle=Create this ticket, description=I want to create a new ticket for another user, category=Other, priority=Low, clientFirstName=Client, clientLastName=Last, email=client.last@gmail.com, dateTicketCreated=2024-12-06]", newTicket1.toString());
	}


}
