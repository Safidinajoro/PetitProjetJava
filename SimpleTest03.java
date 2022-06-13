package swing;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

public class SimpleTest03 {

	public static void main(String[] args) {
		// Create a frame
		JFrame frame = new JFrame("Revised Simplest Swing");
		// Set the default close behavior to exit the application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set the x, y, width and height properties in one go
		frame.setBounds(50, 50, 400, 300);
		//frame.setLocationRelativeTo(null);
		Component glassPane = frame.getGlassPane();
		glassPane.setVisible(true);
		//glassPane.set
		frame.getRootPane().setGlassPane(glassPane);
		glassPane.setBackground(Color.red);
		// Display the frame
		frame.setVisible(true);
	}
}
