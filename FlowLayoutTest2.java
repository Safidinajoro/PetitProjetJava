package swing;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest2 {
	public static void main(String[] args) {
		int horizontalGap = 20;
		int verticalGap = 10;
		JFrame frame = new JFrame("Flow Layout Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, horizontalGap, verticalGap);
		contentPane.setLayout(flowLayout);
		frame.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		for (int i = 1; i <= 30; i++) {
			contentPane.add(new JButton("Button " + i));
		}
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
