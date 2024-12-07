package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Ticket;
import model.TicketPQ;
import model.TicketPQ2;

class TicketPQ2Test {

	Ticket newTicket1 = new Ticket("555", "Create this ticket", "I want to create a new ticket for another user",
			"Other", "Low", "Client", "Last", "client.last@gmail.com", LocalDate.now());

	TicketPQ newTicketPQ1 = new TicketPQ();

	TicketPQ2 pQNewTicket = new TicketPQ2();

	@Test
	void testOffer() {

		assertEquals(true, pQNewTicket.offer(newTicketPQ1));
	}

	@Test
	void testPeek() {

		TicketPQ newTicketPQ3 = new TicketPQ(newTicket1, newTicket1.getPriority());

		pQNewTicket.offer(newTicketPQ3);

		assertEquals(
				"Ticket [ticketNum=555, ticketTitle=Create this ticket, description=I want to create a new ticket for another user, category=Other, priority=Low, clientFirstName=Client, clientLastName=Last, email=client.last@gmail.com, dateTicketCreated=2024-12-06] --- Priority Low",
				pQNewTicket.peek());
	}

	@Test
	void testPoll() {

		Ticket newTicket4 = new Ticket("635", "Create this ticket", "Test", "Other", "High", "Client", "Last",
				"client.last@gmail.com", LocalDate.now());

		TicketPQ newTicketPQ4 = new TicketPQ(newTicket4, newTicket4.getPriority());

		TicketPQ2 pQNewTicket3 = new TicketPQ2();

		pQNewTicket3.offer(newTicketPQ4);

		assertEquals("", pQNewTicket3.poll());

	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}


	@Test
	void testGetTickets() {

		Ticket newTicket5 = new Ticket("779", "Create this ticket", "Test", "Other", "Low", "Client", "Last",
				"client.last@gmail.com", LocalDate.now());

		TicketPQ newTicketPQ5 = new TicketPQ(newTicket5, newTicket5.getPriority());

		assertEquals("Ticket [ticketNum=779, ticketTitle=Create this ticket, description=Test, category=Other, priority=Low, clientFirstName=Client, clientLastName=Last, email=client.last@gmail.com, dateTicketCreated=2024-12-06] --- Priority Low", newTicketPQ5);
	}

}
