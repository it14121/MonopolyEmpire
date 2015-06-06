import java.util.ArrayList;

import javax.swing.JOptionPane;


public class TowerTax extends Space {

	public TowerTax(String aName) {
		super(aName);
	}
	
	public void actOnSpace(Player player, ArrayList<Player> players) {
		if(name.equals("RivalTowerTax")) {// Take another's player topmost brutility.
			 ArrayList<String> otherPlayersCodes = new ArrayList<String>();
			 for(int i = 0; i<=players.size(); i++) {
				 if(players.get(i).getCode() != player.getCode()) {
					 otherPlayersCodes.add(players.get(i).getCode() + "");
				 }
			 }
			 String input = JOptionPane.showInputDialog("Write the player's code whose\n "
			 		+ "topmost billboard you will return on board.");
			 while( !(otherPlayersCodes.contains(input))) {
				 input = JOptionPane.showInputDialog("Write the player's code whose\n "
					 		+ "topmost billboard you will return on board.");
			 }
			 int in = Integer.parseInt(input);
			 Player otherPlayer = null;
		}
		
	
		
	}

	
}
