import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Card extends Space {
	
	private int type;
	private String name;
	private ImageIcon icon;
	
	public Card(int typeOfCard){
		type = typeOfCard;
		name = this.getRandomCard(typeOfCard);
		icon = new ImageIcon(typeOfCard + ".jpg");		
	}
 
    private ArrayList<String> readCards(String name){
    	ArrayList<String> lines = new ArrayList<String>();
    	try{
			FileReader fileIn = new FileReader(name);
			BufferedReader in = new BufferedReader(fileIn);
			String currentLine;
			
			while((currentLine = in.readLine()) != null){
				String line1 = currentLine;
				String line2 = in.readLine();
				String line3 = in.readLine();
				lines.add(line1 + System.lineSeparator() + line2 
						+ System.lineSeparator() +line3 + System.lineSeparator() );
			}
			
			in.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
    	return lines;
    }
    
    
    public String getRandomCard(int type) {
    	ArrayList<String> lines;
    	String name;
    	if(type == 1)
    		name = "≈Õ‘œÀ«.txt";
    	else
    		name = "¡’‘œ —¡‘œ—…¡.txt";
    	lines = readCards(name);
    	Random r = new Random();
		String randomString = lines.get(r.nextInt(lines.size()));
		return randomString;
    }
    
    public void holdCard(Player p){
    	if(name.contains(" Ò‹ÙÁÛÂ ·ıÙﬁÌ ÙÁÌ Í‹ÒÙ·")) {
    		JDialog.setDefaultLookAndFeelDecorated(true);
    	    int response = JOptionPane.showConfirmDialog(null, 
    	    		"Do you want to continue?", 
    	    		"Confirm",
    	    		JOptionPane.YES_NO_OPTION,
    	    		JOptionPane.QUESTION_MESSAGE);
    	    if (response == JOptionPane.YES_OPTION) {
    	    	p.addCardInHand(this);
    	    } 
    	}
//    	if (p.getPosition() == 6 || p.getPosition() == 15 || p.getPosition() == 21 || p.getPosition() == 32){
//    		String random = getRandomCard(1);
//    		//JOptionPane.showMessageDialog(null, random, "Chance Card", JOptionPane.INFORMATION_MESSAGE);
//            JOptionPane.showMessageDialog(null, random, "Chance Card", JOptionPane.INFORMATION_MESSAGE,icon);
//    	}
//    	else if(p.getPosition() == 4 || p.getPosition() == 24){
//    		String random = getRandomCard(2);
//    		//JOptionPane.showMessageDialog(null, random, "Empire Card", JOptionPane.INFORMATION_MESSAGE);
//    		JOptionPane.showMessageDialog(null, random, "Empire Card", JOptionPane.INFORMATION_MESSAGE, icon);   	
//    	}
    }
    
}