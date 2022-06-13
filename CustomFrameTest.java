package swing;

public class CustomFrameTest {
	// Display the CustomFrame
		public static void main(String[] args) {
			CustomFrame frame = new CustomFrame("Custom Frame");
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
}
