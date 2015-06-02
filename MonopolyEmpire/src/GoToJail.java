import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class GoToJail extends Space {
	
	public GoToJail(String aName, int aPos) {
		super(aName, aPos);
	}
	
	public void sendToJail(Player p){
		if (p.getPosition() == 27){
			ImageIcon jail = new ImageIcon("jail.jpg");
			JOptionPane.showMessageDialog(
	                null,
	                null,
	                "Go to Jail", JOptionPane.INFORMATION_MESSAGE,
	                jail);
		}
			
	}

}
