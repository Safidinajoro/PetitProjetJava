package swing;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.Dimension;

public class AddingComponentToJFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Adding Component to JFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		// Add a close button
		JButton closeButton = new JButton("Fermer");
		contentPane.add(closeButton);
		// set the size of the frame 300 x 200
		//frame.setBounds(50, 50, 300, 200);
		Dimension d = new Dimension(300,200);
		frame.setSize(d);
		frame.setLocationRelativeTo(null);
		//frame.pack();
		frame.setVisible(true);
	}
}
