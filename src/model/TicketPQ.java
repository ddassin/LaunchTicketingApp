package model;

public class TicketPQ implements Comparable<Ticket> {

	// Data Members
	private Ticket newTicket;
	private String ticketPriority; // priority of ticket

	private String defaultPriority = "Low";

	private final int ONE = 1;
	private final int TWO = 2;
	private final int THREE = 3;
	private final int FOUR = 4;

	/**
	 * This is no args constructor to that creates the object
	 */
	public TicketPQ() {
		this.ticketPriority = defaultPriority;
	}

//	/**
//	 * This is one arg constructor that takes in one parameter and sets a default of
//	 * low priority if no priority is given
//	 * 
//	 * @param
//	 */
//	public TicketPQ(Ticket newTicket) {
//		this.newTicket = newTicket;
//		this.ticketPriority = defaultPriority;
//	}

	/**
	 * This is a two args constructor to initialize the job and the priority
	 * 
	 * @param jobNumber - job element
	 * @param priority  - priority of element
	 */
	public TicketPQ(Ticket newTicket, String priority) {
		this.newTicket = newTicket;
		this.ticketPriority = priority;
	}

	/**
	 * Getter method for the TicketPriority
	 * 
	 * @return the ticketPriority
	 */
	public String getTicketPriority() {
		return ticketPriority;
	}

	/**
	 * Helper method to compare the ticket priorities
	 * 
	 * @param other
	 * @return the compared outcome
	 */
	
	public int compareTo(TicketPQ other) {
//		return this.ticketPriority.compareTo(other.ticketPriority);
		return getPriorityValue(other.ticketPriority) - getPriorityValue(this.ticketPriority);
	}
	

	@Override
	public int compareTo(Ticket o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Helper Method
	 * 
	 * @return the string representation
	 */
	public String printJob() {

		return "Ticket Number " + this.newTicket + "," + this.ticketPriority;
	}

	/**Helper method to send back the value based priority 
	 * 
	 * @param priority
	 * @return value
	 */
	private int getPriorityValue(String priority) {
		switch (priority.toLowerCase()) {
		case "critical":
			return ONE;
		case "high":
			return TWO;
		case "medium":
			return THREE;
		case "low":
			return FOUR;
		default:
			return FOUR;
		}
		
	}

	/**
	 * Helper method toString method
	 * 
	 * @return the string representation
	 */
	@Override
	public String toString() {
		return this.newTicket + " --- Priority " + this.ticketPriority;
	}


}