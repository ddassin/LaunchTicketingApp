package model;

/**
 * This is the Ticket class file. A new ticket is created when the user submits a ticket request 
 */



import java.time.LocalDate;
import java.util.regex.Pattern;

// Data Members 
public class Ticket   {

	private String ticketNum; // the id of the ticket
	private static int ticketStartCount = 605; // counter for keeping track of the ticket number

	private String subject;
	private String description;
	private String category;
	private String priority;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dateTicketCreated;
	
	/**
	 * Default no args constructor
	 */
	public Ticket() {

		ticketNum = "";
		subject = "";
		description = "";
		category = "";
		priority = "";
		firstName = "";
		lastName = "";
		email = "";
		dateTicketCreated = LocalDate.now();

	}

	/**
	 * args constructor
	 */
	public Ticket(String ticketNum, String subject, String description, String category, String priority,
			String firstName, String lastName, String email, LocalDate dateTicketCreated) {

		setTicketNum(ticketNum);
		setSubject(subject);
		setDescription(description);
		setCategory(category);
		setPriority(priority);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setDateTicketCreated(dateTicketCreated);
	}

	/**
	 * @return the ticketNum
	 */
	public String getTicketNum() {

		return ticketNum;
	}

	/**
	 * @param ticketNum the ticketNum to set
	 */
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	/**
	 * HELPER METHOD TO SEND THE TICKET NUMBER
	 * 
	 * @return
	 */
	public int sendTicketNumber() {

		return ticketStartCount++;

	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {

		return email;
	}

	/**
	 * @param email the email to set
	 * // code from - https://www.geeksforgeeks.org/check-email-address-valid-not-java/
	 */
	public void setEmail(String email) {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		// Compile the regex
		Pattern p = Pattern.compile(emailRegex);

		// Check if email matches the pattern
		if (email == null && !p.matcher(email).matches()) {
			throw new IllegalArgumentException("Invalid email address format.");
		}

		this.email = email;

	}

	/**
	 * @return the dateTicketCreated
	 */
	public LocalDate getDateTicketCreated() {
		return dateTicketCreated;
	}

	/**
	 * @param dateTicketCreated the dateTicketCreated to set
	 */
	public void setDateTicketCreated(LocalDate dateTicketCreated) {
		this.dateTicketCreated = dateTicketCreated;
	}

	/**
	 * @return A string representation of the ticket
	 */
	@Override
	public String toString() {
		return "Ticket [ticketNum=" + ticketNum + ", ticketTitle=" + subject + ", description=" + description
				+ ", category=" + category + ", priority=" + priority + ", clientFirstName=" + firstName + ", clientLastName="
				+ lastName + ", email=" + email + ", dateTicketCreated=" + dateTicketCreated + "]";
	}

}