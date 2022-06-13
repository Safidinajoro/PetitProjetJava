package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class EventHandlingFrameTest extends JFrame {
	JButton closeButton = new JButton("Close");

	public EventHandlingFrameTest() {
		super("Simplest Event Handling JFrame");
		this.initFrame();
	}

	private void initFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
// Set a FlowLayout for the content pane
		this.setLayout(new FlowLayout());
// Add the Close JButton to the content pane
		this.getContentPane().add(closeButton);
// Add an ActionListener to closeButton
		
		//closeButton.addActionListener(e -> System.exit(0));
//		closeButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				for(int i = 0 ; i < 3 ; i++)
//					System.out.println("Bonjour !!!");
//			}
//		});
		closeButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse clicked");
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Mouse pressed");
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Mouse Released");
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse Entered");
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse Exited");
				
			}
			
		});
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse clicked selon Adapter");
				
			}
		});
	}

	public static void main(String[] args) {
		EventHandlingFrameTest frame = new EventHandlingFrameTest();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
