package swing;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class TicTacToe extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel p=new JPanel();
	private OXButton buttons[]=new OXButton[9];
	
	public static void main(String args[]){
		new TicTacToe();
	}
		
	public TicTacToe(){
		super("TicTacToe");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++){
			buttons[i] = new OXButton();
			p.add(buttons[i]);
		}
		add(p);
		setVisible(true);
	}
}