package swing;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OXButton extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	ImageIcon X,O;
	byte value=0; 	/*	0:rien 	1:X  2:O */
	
	public OXButton(){
		X=new ImageIcon(this.getClass().getResource("X.png"));
		O=new ImageIcon(this.getClass().getResource("O.png"));
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		value++;
		value%=3;
		switch(value){
			case 0:
				setIcon(null);
				break;
			case 1:
				setIcon(X);
				break;
			case 2:
				setIcon(O);
				break;
		}
	}
}