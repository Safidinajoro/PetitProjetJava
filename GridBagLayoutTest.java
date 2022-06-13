package swing;

import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.GridBagLayout;

public class GridBagLayoutTest {
	public static void main(String[] args) {
		String title = "GridBagLayout in its Simplest Form";
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		for (int i = 1; i <= 9; i++) {
			contentPane.add(new JButton("Button " + i));
		}
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
