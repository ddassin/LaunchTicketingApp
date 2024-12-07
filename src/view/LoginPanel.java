package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel {

	// Data Members
	private JPasswordField passwordField;
	private JTextField userNameField;
	private JLabel passwordLabel;
	private JLabel usernameLabel;
	private JLabel messageLabel1;
	private JButton signInButton;
	private JButton resetButton;
//	private Color color = Color.orange;;
	
	private JPanel buttonPanel;
	
	// Numbers 
	private final int ZERO = 0;
	private final int TWO = 2;
	private final int FOUR = 4;
	private final int SEVEN = 7;
	private final int TEN = 10;
	private final int TWELVE = 12;
	private final int TWENTY = 12;
	
	


	public LoginPanel() {

		// Use GridBagLayout
		setLayout(new GridLayout(SEVEN, TWO, ZERO, ZERO));
		setBorder(BorderFactory.createEmptyBorder(TEN, TEN, TEN, TEN)); // Adding padding around the edges of the components
		
		JLabel title = new JLabel("Enter Your Username and Password", SwingConstants.CENTER);

		// Title
		title.setForeground(Color.GRAY);
		add(title);

		usernameLabel = new JLabel("Username", SwingConstants.CENTER);
		usernameLabel.setForeground(Color.GRAY);
		add(usernameLabel);

		userNameField = new JTextField(TWELVE);
		add(userNameField);

		passwordLabel = new JLabel("Password", SwingConstants.CENTER);
		passwordLabel.setForeground(Color.GRAY);
		add(passwordLabel);

		passwordField = new JPasswordField(TWENTY);
		add(passwordField);	

		// creating a button panel
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, FOUR, FOUR));

		ButtonListener ButtonListener = new ButtonListener();

		signInButton = new JButton("Sign in");
		signInButton.setForeground(Color.DARK_GRAY);
		signInButton.setBackground(Color.lightGray);
		signInButton.addActionListener(ButtonListener);
		buttonPanel.add(signInButton);

		resetButton = new JButton("Reset");
		resetButton.setForeground(Color.DARK_GRAY);
		resetButton.setBackground(Color.lightGray);
		resetButton.addActionListener(ButtonListener);
		buttonPanel.add(resetButton);
		
		messageLabel1 = new JLabel("Username: Data and Password: Structures");
		messageLabel1.setForeground(Color.GRAY);
		buttonPanel.add(messageLabel1);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	/** Button listener for handling button clicks
	 * ActionListener assigns actions to the jbutton
	 */
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();

			if (e.getSource() == signInButton) {
				String userText = userNameField.getText();
				String pwdText = new String(passwordField.getPassword());

				if (userText.equalsIgnoreCase("Data") && pwdText.equalsIgnoreCase("Structures")) {
					JOptionPane.showMessageDialog(null, "Correct Credentials", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
					newPanel = new FirstMenuOptionsPanel();
					sendToNewPanel(newPanel);
				}

				else {
					JOptionPane.showMessageDialog(null, "Invalid username and password", "Invalid!",
							JOptionPane.ERROR_MESSAGE);
					resetButton();
				}
			}

			else if (e.getSource() == resetButton) {

				resetButton();

			}

		}

		// resetting the fields
		private void resetButton() {
			userNameField.setText("");
			passwordField.setText("");

		}

		// sending to a new jpanel
		private void sendToNewPanel(JPanel newPanel) {
			removeAll();
			setVisible(false);
			getParent().add(newPanel);
			getParent().validate();
			getParent().repaint();

		}

	}
}
