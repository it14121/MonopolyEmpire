import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;


public class Dice {
	
	private int dice1;
	private int dice2;
	private boolean sneakySwapping;
	private boolean isDouble;
	
	public Dice() {
		sneakySwapping = false;
		isDouble = false;
	}
	
	public int rollTheDice(Player player, ArrayList<Player> players) {
		 dice1 = (int)(Math.random()) % 6 + 1;
		 dice2 = (int)(Math.random()) % 6 + 1;
		 sneakySwapping = false;
		 isDouble = false;
		 
		 if ( dice1 == 1 ) {
			 int optionPane = JOptionPane.showConfirmDialog(null, 
					 "Do you want to roll a sneaky swap?", 
					 "Message", 
					 JOptionPane.QUESTION_MESSAGE, 
					 JOptionPane.YES_NO_OPTION);
			 if(optionPane == JOptionPane.YES_OPTION) {
				 ArrayList<String> otherPlayersCodes = new ArrayList<String>();
				 for(int i = 0; i<=players.size(); i++) {
					 if(players.get(i).getCode() != player.getCode()) {
						 otherPlayersCodes.add(players.get(i).getCode() + "");
					 }
				 }
				 String input = JOptionPane.showInputDialog("Write the player's code that\n "
				 		+ "you want to roll a sneaky swap.");
				 while( !(otherPlayersCodes.contains(input))) {
					 input = JOptionPane.showInputDialog("Write the player's code that\n "
						 		+ "you want to roll a sneaky swap.");
				 }
				 int in = Integer.parseInt(input);
				 Player otherPlayer = null;
				 for(int i = 0; i<=players.size(); i++) {
					 if(players.get(i).getCode() == in)
						 otherPlayer =  players.get(i);
				 }
				 Brutility brutilityOfPlayer =  player.getMyScyscraper().getTheTopBrutility();
				 Brutility brutilityOfOtherPlayer = otherPlayer.getMyScyscraper().getTheTopBrutility();
				 otherPlayer.getMyScyscraper().addBrutility(brutilityOfPlayer);
				 player.getMyScyscraper().addBrutility(brutilityOfOtherPlayer);
			 }
		 }
		 
		 if( dice1 == dice2) {
			 isDouble = true;
		 }
		 return dice1 + dice2;
	}
	
	public boolean isSneakySwapping() {
		return sneakySwapping;
	}
	
	public boolean isDouble() {
		return isDouble;
	}

}
