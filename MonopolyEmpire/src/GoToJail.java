import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GoToJail extends Space {
	
	public GoToJail() 
	{
		super("Go To Jail");
	}
	
	public static void sendToJail(Player player)
	{
		ImageIcon jail = new ImageIcon("ImagesGameGUI/jail.jpg");
		JOptionPane.showMessageDialog(null, null, "Go to Jail", JOptionPane.INFORMATION_MESSAGE,
	                				jail);		
	}

}