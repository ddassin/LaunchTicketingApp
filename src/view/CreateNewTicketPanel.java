package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ticket;
import model.TicketPQ;
import model.TicketPQ2;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

public class CreateNewTicketPanel extends JPanel {
	// Data members and the JPanel Components that will go into the grid
	private JTextField ticketNumField;
	private JTextField dateField;
	private JTextField subjectField;
	private JTextField descriptionField;

	private JComboBox<String> comboBoxCategory;
	private JComboBox<String> comboBoxPriority;

	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;

	private JButton submitButton;
	private JButton clearFieldButton;
	private JButton mainMenuButton;
	private JButton endProgramButton;

	private JButton viewTickets;

	private Ticket ticket = new Ticket(); // creating an instance of Ticket to capture the ticket number and date

	private JLabel title = new JLabel("Submit New Ticket Request");

	private Color color = Color.LIGHT_GRAY; // color

	// Numbers
	private final int FOUR = 4;
	private final int FIVE = 5;
	private final int EIGHT = 8;
	private final int TEN = 10;
	private final int TWENTY = 20;

	private TicketPQ allTicketsPQ;

	TicketPQ2 ticketQ2 = TicketPQ2.getInstance();

	// Constructor of the jpanel
	public CreateNewTicketPanel() {

		// Use GridBagLayout
		setLayout(new GridLayout(EIGHT, EIGHT, EIGHT, EIGHT));
		setBorder(BorderFactory.createEmptyBorder(FIVE, FIVE, FIVE, FIVE)); // Adding padding around the edges

		// creating and adding components to the panel
		// Title
		add(title);
		add(new JLabel()); // Placeholder label

		// Ticket Number Label and Placement
		add(new JLabel()); // Placeholder label
		add(new JLabel()); // Placeholder label
		JLabel ticketNumberLabel = new JLabel("Ticket Number:");
		add(ticketNumberLabel);

		ticketNumField = new JTextField(FOUR);
		ticketNumField.setEditable(false);
		ticketNumField.setText(String.valueOf((ticket.sendTicketNumber())));
		add(ticketNumField);

//	    Date
		JLabel dateLabel = new JLabel("Ticket Created Date:");
		add(dateLabel);

		dateField = new JTextField(TEN);
		dateField.setEditable(false); // setting the textfield to not editable
		dateField.setText(String.valueOf((ticket.getDateTicketCreated()))); // getting the ticket date
		add(dateField);

		// Subject Label and Placement
		JLabel subjectLabel = new JLabel("Ticket Title:");
		add(subjectLabel);

		subjectField = new JTextField(TWENTY);
		add(subjectField);

		// Description Label and Placement
		JLabel descriptionLabel = new JLabel("Ticket Description:");
		add(descriptionLabel);

		descriptionField = new JTextField(100);
		add(descriptionField);

		// Ticket Category Dropdown Label and Placement
		JLabel ticketCategoryLabel = new JLabel("Ticket Category:");
		add(ticketCategoryLabel);
		comboBoxCategory = new JComboBox<>();
		comboBoxCategory.setModel(new DefaultComboBoxModel<>(
				new String[] { "Device Issue", "File Import", "General Question", "System Down", "Other" }));
		add(comboBoxCategory);

		// Ticket Priority Dropdown Label and Placement
		JLabel ticketPriorityLabel = new JLabel("Ticket Priority:");
		add(ticketPriorityLabel);
		comboBoxPriority = new JComboBox<>();
		comboBoxPriority.setModel(new DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High", "Critical" }));
		add(comboBoxPriority);

		// First Name Label and Placement
		JLabel firstNameLabel = new JLabel("Client First Name:");
		add(firstNameLabel);
		firstNameField = new JTextField(TWENTY);
		add(firstNameField);

		// Last Name Label and Placement
		JLabel lastNameLabel = new JLabel("Client Last Name:");
		add(lastNameLabel);
		lastNameField = new JTextField(TWENTY);
		add(lastNameField);

		// Email Address Label and Placement
		JLabel emailLabel = new JLabel("Client Email Address:");
		add(emailLabel);
		emailField = new JTextField(TWENTY);
		add(emailField);

		// Buttons creation and Placement
		ButtonListener buttonListener = new ButtonListener();
		// submit button
		add(new JLabel()); // Placeholder label
		add(new JLabel()); // Placeholder label
		add(new JLabel()); // Placeholder label
		submitButton = new JButton("Submit Ticket");
		submitButton.addActionListener(buttonListener);
		add(submitButton);

		// clear button
		clearFieldButton = new JButton("Clear");
		clearFieldButton.addActionListener(buttonListener);
		add(clearFieldButton);

		// view all tickets button
		viewTickets = new JButton("View All Tickets");
		viewTickets.addActionListener(buttonListener);
		add(viewTickets);

		// main menu button
		add(new JLabel()); // Placeholder label
		mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addActionListener(buttonListener);
		add(mainMenuButton);

		// end program button
		endProgramButton = new JButton("End Program");
		endProgramButton.addActionListener(buttonListener);
		add(endProgramButton);



		// Setting the background color
		setBackground(color);
	}

	/**
	 * Button listener for handling button clicks ActionListener assigns actions to
	 * the jbutton
	 */
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			JPanel newPanel = null;

			if (e.getSource() == submitButton) {

				// creating variable and assigning them the text from the j panel text fileds
				String ticketNumber = ticketNumField.getText();
				String subject = subjectField.getText();
				String description = descriptionField.getText();
				String category = (String) comboBoxCategory.getSelectedItem();
				String priority = (String) comboBoxPriority.getSelectedItem();
				String first = firstNameField.getText();
				String last = lastNameField.getText();
				String email = emailField.getText();

				LocalDate ticketDate = LocalDate.parse(dateField.getText()); // converting datefield to string

				try {

					// Checking if empty fields exist in the ticket entry field
					if (!emptyFields(subject) || !emptyFields(description) || !emptyFields(first) || !emptyFields(last)
							|| !emptyFields(email) || !emptyFields(email)) {
						// displaying a message to the user to inform them that the fields cannot be
						// blank
						JOptionPane.showMessageDialog(null, "No empty fields allow!", "Error Message",
								JOptionPane.ERROR_MESSAGE);

					}

					else if (!validEmaill(email)) {
						// displaying a message to the user to inform them that the email address is
						// wrong
						JOptionPane.showMessageDialog(null, "Please enter a correct email address!", "Error Message",
								JOptionPane.ERROR_MESSAGE);
					}

					else {

						/// getting the generated ticket number
						ticketNumField.setText(String.valueOf((ticket.sendTicketNumber())));
						// creating a new ticket
						Ticket newTicket = new Ticket(ticketNumber, subject, description, category, priority, first,
								last, email, ticketDate);

						JOptionPane.showMessageDialog(null, "Ticket Created!", "Info!",
								JOptionPane.INFORMATION_MESSAGE);

						// createing a new TicketPQ and sending in the created tickets and the priority
						allTicketsPQ = new TicketPQ(newTicket, priority);
						// adding the tickets to the TicketPQ priority queue
						ticketQ2.offer(allTicketsPQ);
						clearAllFields();
					}
				}

				catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Error! Please try again!", "Error!",
							JOptionPane.ERROR_MESSAGE);
					clearAllFields();
				}

			} else if (e.getSource() == clearFieldButton) {
				clearAllFields();

				// when the viewTickets button is clicked
			} else if (e.getSource() == viewTickets) {
				newPanel = new AllTicketsPage(ticketQ2);
				sendToNewPanel(newPanel);

			}

			// when the endProgram button is clicked
			else if (e.getSource() == endProgramButton) {

				System.exit(0);

			}

			// when the mainMenu button is clicked
			else if (e.getSource() == mainMenuButton) {
				newPanel = new FirstMenuOptionsPanel();
				sendToNewPanel(newPanel);

			}

			if (newPanel != null) {
				sendToNewPanel(newPanel);
			}
		}

		/**
		 * Method to switch to a new panel
		 * 
		 * @param newPanel
		 */
		// Method to switch to a new panel
		private void sendToNewPanel(JPanel newPanel) {
			removeAll(); // Remove all components from the current panel
			setVisible(false); // make current panel not visible
			getParent().add(newPanel);// Add the new panel
			getParent().validate(); // Refresh the layout
			getParent().repaint(); // Repaint the page

		}

		/**
		 * Method to reset all fields
		 */
		private void clearAllFields() {
			subjectField.setText("");
			descriptionField.setText("");
			firstNameField.setText("");
			lastNameField.setText("");
			emailField.setText("");
			comboBoxCategory.setSelectedIndex(0); // Reset to the first item
			comboBoxPriority.setSelectedIndex(0); // Reset to the first item
		}

		/**
		 * Method that determines whether the field is empty or now
		 * 
		 * @param field
		 * @return
		 */
		private boolean emptyFields(String field) {

			if (field == null || field.isEmpty()) {
				return false;
			}
			return true;
		}

		/**
		 * 
		 * @param email
		 * @return true if email matches pattern and false if it does not // code from -
		 *         https://www.geeksforgeeks.org/check-email-address-valid-not-java/
		 */
		private boolean validEmaill(String email) {

			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			// Compile the regex
			Pattern p = Pattern.compile(emailRegex);

			// Check if email matches the pattern
			if (p.matcher(email).matches()) {

				return true;
			}
			return false;
		}
	}
}
