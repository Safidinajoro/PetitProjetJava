package swing;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class JButtonClickedCounter extends JFrame {
	int counter;
	JButton counterButton = new JButton("Clicked #0");
	JButton closeButton = new JButton("Close");

	public JButtonClickedCounter() {
		super("JButton Clicked Counter");
		this.initFrame();
	}

	private void initFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Set a FlowLayout for the content pane
		this.setLayout(new FlowLayout());
		// Add two JButtons to the content pane
		this.getContentPane().add(counterButton);
		this.getContentPane().add(closeButton);
		// Add an ActionListener to the counter JButton
		counterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Increment the counter and set the JButton text
				counter++;
				counterButton.setText("Clicked #" + counter);
			}
		});
		// Add an ActionListener to closeButton
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Exit the application, when this button is pressed
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		JButtonClickedCounter frame = new JButtonClickedCounter();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
