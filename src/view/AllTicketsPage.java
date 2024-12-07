package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.TicketPQ;
import model.TicketPQ2;

public class AllTicketsPage extends JPanel {

	private JLabel allTicketsLabel = new JLabel("All Tickets");

	private JButton mainMenuButton = new JButton("Return to Main Menu");
	private JButton exitButton = new JButton("Exit App");

//	private JButton createNewTicket = new JButton("New Ticket");	

	private Color color = Color.orange;;
	private JPanel ticketDisplayPanel = new JPanel();

	private TicketPQ2 newTicketPQ2;

//	Numbers
	private final int ZERO = 0;
	private final int EIGHT = 8;

	/**
	 * one-args constructor
	 * 
	 * @param newTicketPQ2
	 */
	public AllTicketsPage(TicketPQ2 newTicketPQ2) {

		this.newTicketPQ2 = newTicketPQ2;

		setLayout(new BorderLayout());
		JLabel allTicketsLabel = new JLabel("All Tickets");
		add(allTicketsLabel, BorderLayout.NORTH);

		// Add ticket display area
		ticketDisplayPanel.setLayout(new BoxLayout(ticketDisplayPanel, BoxLayout.Y_AXIS));

		displayTickets();

		// Attching events to the buttons
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, EIGHT, EIGHT));
		ButtonListener buttonListener = new ButtonListener();
//		createNewTicket.add(buttonPanel);
		mainMenuButton.addActionListener(buttonListener);
		exitButton.addActionListener(buttonListener);

		// adding buttons to button panel
		buttonPanel.add(mainMenuButton);
//		buttonPanel.add(createNewTicket);
		buttonPanel.add(exitButton);
		// adding button panel to the jframe
		add(buttonPanel, BorderLayout.SOUTH);

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

			if (e.getSource() == mainMenuButton) {
				newPanel = new FirstMenuOptionsPanel();
				sendToNewPanel(newPanel);

			}

			else if (e.getSource() == exitButton) {
				// Exit the program
				System.exit(ZERO);
			}

			if (newPanel != null) {
				sendToNewPanel(newPanel);
			}
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
	 * Display tickets in the panel, sorted by priority.
	 * 
	 * @param ticketPQ2
	 */
	private void displayTickets() {
		setLayout(new BorderLayout());
		ticketDisplayPanel.setLayout(new BoxLayout(ticketDisplayPanel, BoxLayout.Y_AXIS));

		if (newTicketPQ2 != null && newTicketPQ2.size() > ZERO) {

			for (TicketPQ ticket : newTicketPQ2.getTickets()) {
				JLabel ticketLabel = new JLabel(ticket.toString());
				ticketDisplayPanel.add(ticketLabel);
			}
		} else {
			ticketDisplayPanel.add(new JLabel("No tickets available."));
		}

		add(new JScrollPane(ticketDisplayPanel), BorderLayout.CENTER);
	}

}
