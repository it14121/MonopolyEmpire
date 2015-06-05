import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import Card.ActListener;


public class JustVisiting extends Space {
	
	public JustVisiting(String aName, int aPos) {
		super(aName, aPos);
		name = aName;
		position = aPos;
	}
	
	public void onJustVisiting() {
		JFrame frame = new JFrame("Message");
		JOptionPane.showConfirmDialog(frame, "You are here just for visiting.\n You do nothing at all.");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
	
	
}
