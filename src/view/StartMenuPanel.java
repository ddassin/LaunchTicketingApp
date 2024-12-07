package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//This should be the first page that the user sees 

public class StartMenuPanel extends JPanel {

//	I just want to have a filed to enter in the user email address and their username 
	// Initial user interface
	private JLabel welcomeJLabel = new JLabel(
			"                           Welcome to the Service Portal: Click Start to login to the system!");
	private JButton startButton = new JButton("Start");
	private Color color = Color.lightGray;;
//	private Color white = Color.white;;

	public StartMenuPanel() {

		setLayout(new BorderLayout());

		ButtonListener start = new ButtonListener();

		startButton.addActionListener(start);

		// adding the labels to the first Jpanel, which is the intro screen/panel
		add(welcomeJLabel, BorderLayout.NORTH);

		add(startButton, BorderLayout.SOUTH);
		startButton.setForeground(Color.lightGray);
		startButton.setBackground(Color.gray);
		setBackground(color);
		add(welcomeJLabel);
	}

	/** Button listener for handling button clicks
	 * ActionListener assigns actions to the jbutton
	 */
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();

			if (e.getSource() == startButton) {
				newPanel = new LoginPanel();
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