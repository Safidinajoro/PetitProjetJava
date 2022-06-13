package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGlassPane {

	public static void main(String[] args) {
		new TestGlassPane();
	}

	public TestGlassPane() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new TestPane());
				frame.setGlassPane(new GlassPane());
				frame.getGlassPane().setVisible(true);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
	
	
    
	public class TestPane extends JPanel {

		public TestPane() {
			setLayout(new BorderLayout());
			try {
				ImageIcon icon = createImageIcon("images3.jpg");
				add(new JLabel(icon));
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		public ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL = TestGlassPane.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	    }

	}

	public class GlassPane extends JPanel {

		private MenuPane menuPane;

		public GlassPane() {
			setOpaque(false);
			menuPane = new MenuPane();
			add(menuPane);
			setLayout(new SlidingMenuLayoutManager());

			menuPane.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					((SlidingMenuLayoutManager) getLayout()).open();
				}

				@Override
				public void mouseExited(MouseEvent e) {
					((SlidingMenuLayoutManager) getLayout()).close();
				}

			});
		}

		protected class SlidingMenuLayoutManager implements LayoutManager {

			private int offSet = 10;
			private int delta = 2;
			private Timer slider;

			public SlidingMenuLayoutManager() {
				slider = new Timer(10, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println("...");
						offSet += delta;
						if (offSet <= 10) {
							offSet = 10;
							((Timer) e.getSource()).stop();
						} else if (offSet >= menuPane.getWidth()) {
							offSet = menuPane.getWidth();
							((Timer) e.getSource()).stop();
						}
						menuPane.getParent().revalidate();
						menuPane.getParent().repaint();
					}
				});
			}

			public void open() {
				slider.stop();
				delta = 2;
				slider.start();
			}

			public void close() {
				slider.stop();
				delta = -2;
				slider.start();
			}

			@Override
			public void addLayoutComponent(String name, Component comp) {
			}

			@Override
			public void removeLayoutComponent(Component comp) {
			}

			@Override
			public Dimension preferredLayoutSize(Container parent) {
				Dimension size = menuPane.getPreferredSize();
				size.width *= 2;
				return size;
			}

			@Override
			public Dimension minimumLayoutSize(Container parent) {
				return preferredLayoutSize(parent);
			}

			@Override
			public void layoutContainer(Container parent) {
				Dimension size = menuPane.getPreferredSize();
				size.height = parent.getHeight();
				menuPane.setSize(size);

				int maxWidth = size.width;
				int xPos = offSet - maxWidth;
				menuPane.setLocation(xPos, 0);
			}

		}

	}

	public class MenuPane extends JPanel {

		public MenuPane() {
			setOpaque(false);
			setBackground(new Color(0, 0, 255, 64));
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(100, 100);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
		}

	}

}
