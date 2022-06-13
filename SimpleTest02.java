package swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SimpleTest02 {
	
	public static void main(String[] args) {
		JFrame frame;
		SwingUtilities.invokeLater(() -> show());
	}
	
	public static JFrame show() {
		JFrame fr = new JFrame("Test");
		fr.setVisible(true);
		return fr;
	}
}
