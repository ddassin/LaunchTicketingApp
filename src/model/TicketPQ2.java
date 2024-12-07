package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class TicketPQ2 {

	// Data Members

	private LinkedList<TicketPQ> ticketQ;

	private static TicketPQ2 instance;

	private final int ZERO = 0;

	// Create a new list using class attribute
	public TicketPQ2() {

		ticketQ = new LinkedList<TicketPQ>();

	}

	/**
	 * Adds the specified element as the tail (last element) of this list.
	 * 
	 * @param TicketPQ newTicket
	 */
	// Adds a new ticket to the queue ensuring that it is in order of prioity
	public boolean offer(TicketPQ newTicket) {
		if (ticketQ.isEmpty()) {
			ticketQ.add(newTicket);
		} else {
			// Insert based on priority
			int index = ZERO;
			for (TicketPQ ticket : ticketQ) {
				if (newTicket.compareTo(ticket) > ZERO) {
					break;
				}
				index++;
			}
			ticketQ.add(index, newTicket);
		}
		return true;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if
	 * this queue is empty
	 * 
	 * @return
	 */
	public TicketPQ peek() {

		if (!ticketQ.isEmpty()) {
			return ticketQ.peekFirst();
		} else {
			return null;
		}
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue
	 * is empty.
	 * 
	 * @return the removed head of this queue or null if this queue is empty
	 */

	public TicketPQ poll() {
		if (!ticketQ.isEmpty()) {
			ticketQ.removeFirst();
			return ticketQ.getFirst();

		} else {
			return null;
		}
	}

	/**
	 * Retrieves and removes the head (first element) of this list.
	 * 
	 * @param - element to be removed from this queue, if present
	 * @return head of the queue
	 * @throws NoSuchElementException
	 */
	public void remove() {
		if (!ticketQ.isEmpty()) {
			ticketQ.removeFirst();
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Returns the number of elements in this collection.
	 * 
	 * @return the size of the list
	 */

	public int size() {

		return ticketQ.size();
	}

	/**
	 * 
	 * @return instance
	 */
	public static TicketPQ2 getInstance() {

		if (instance == null) {
			instance = new TicketPQ2();
		}

		return instance;
	}

	/**
	 * Helper method to get ticket
	 * 
	 * @return
	 */
	public List<TicketPQ> getTickets() {
		return new ArrayList<>(ticketQ);
	}

	/**
	 * 
	 * @return A string representation of the queue
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Ticket Queue:\n");
		for (TicketPQ ticket : ticketQ) {
			sb.append(ticket).append("\n");
		}
		return sb.toString();
	}

}
