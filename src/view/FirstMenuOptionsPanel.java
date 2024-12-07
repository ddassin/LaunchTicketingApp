package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstMenuOptionsPanel extends JPanel {

	// Option menu
	private JLabel selectOptionLabel = new JLabel("    Please Select From the Below Options");
	private JButton createNewTicket = new JButton("Create a New Ticket Request");
	private JButton exitButton = new JButton("Exit Application");

	private Color color = Color.orange;

	private final int ZERO = 0;
	private final int TWO = 2;
	private final int ONE = 1;
	private final int FIVE = 5;
	private final int TWENTY = 20;

	public FirstMenuOptionsPanel() {

		// Button listeners
		ButtonListener optionButtons = new ButtonListener();
		createNewTicket.addActionListener(optionButtons);
		exitButton.addActionListener(optionButtons);

		// Set up the option menu panel
		JPanel optionMenuPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(TWO, ONE, FIVE, FIVE);
		optionMenuPanel.setLayout(gridLayout);
		setLayout(new BorderLayout());

		// Add components
		add(selectOptionLabel, BorderLayout.NORTH);
		optionMenuPanel.setBorder(BorderFactory.createEmptyBorder(TWENTY, TWENTY, TWENTY, TWENTY));
		optionMenuPanel.add(createNewTicket);
		optionMenuPanel.add(exitButton);
		add(optionMenuPanel, BorderLayout.CENTER);

		// Set background
		setBackground(color);
	}

	/** Button listener for handling button clicks
	 * ActionListener assigns actions to the jbutton
	 */
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = null;

			if (e.getSource() == createNewTicket) {
				newPanel = new CreateNewTicketPanel(); // send to new page that will create the ticket
				sendToNewPanel(newPanel);
			} else if (e.getSource() == exitButton) {
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
	private void sendToNewPanel(JPanel newPanel) {

		removeAll(); // Remove all components from the current panel
		setVisible(false); // make current panel not visible
		getParent().add(newPanel);// Add the new panel
		getParent().validate(); // Refresh the layout
		getParent().repaint(); // Repaint the page

	}
}
