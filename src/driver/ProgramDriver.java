package driver;

import javax.swing.JFrame;

import view.StartMenuPanel;

/**
 * LAUNCH TICKETING SYSTEM PROGRAM description: This app is a ticketing system that allows users to enter in tickets for issues them may have 
 * 
 * @author Dehkontee Dassin
 * @version 1.0
 * @since 1.0 CIS152 12464 Dec 9, 2024
 */
/*
 * OS: Windows IDE: eclipse Copyright : This is my own original work based on
 * specifications issued by our instructor Academic Honesty: I attest that this
 * is my original work. I have not used unauthorized source code, either
 * modified or unmodified, nor used generative AI as a final draft. I have not
 * given other fellow student(s) access to my program.
 */

public class ProgramDriver {

	public static void main (String[] args ) {
		
		// setting the size of the frame
//		frame.setTitle("A frame that has labels, a field and a submit button");
		int FRAME_WIDTH = 550;
		int FRAME_HEIGHT = 500;
		
		JFrame newFrame = new JFrame();
		
		StartMenuPanel panel = new StartMenuPanel();

		newFrame.add(panel);
		newFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		newFrame.setTitle("LAUNCH Ticketing!");
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setLocationRelativeTo(null); // Center the frame on the screen
		newFrame.setVisible(true);
	}

}
