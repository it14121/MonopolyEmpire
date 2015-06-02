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
	
	private static ArrayList<String> chance ;
	private static ArrayList<String> empire;
	private int type;
	private String content;
	private ImageIcon icon;
	
	public Card(String aName, int aPos){
		super(aName, aPos);
		chance = new ArrayList<String>();
		empire = new ArrayList<String>();
		chance = readCards("≈Õ‘œÀ«.txt");
		empire = readCards("¡’‘œ —¡‘œ—…¡.txt");
	}
	
	public Card takeACard(int typeOfCard, String theContent, int aPos) {
		position = aPos;
		type = typeOfCard;
		if(typeOfCard == 1 )
			name = "chance";
		else
			name = "empire";
		content = theContent;
		icon = new ImageIcon(typeOfCard + ".jpg");
		return this;
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
    
    
    public Card getRandomCard(int type) {
    	ArrayList<String> lines;
    	if(type == 1)
    		lines = chance;
    	else
    		lines = empire;
    	Random r = new Random();
		String randomString = lines.get(r.nextInt(lines.size()));
		Card randomCard = this.takeACard(type, randomString, 6);
		return randomCard;
    }
    
    public void holdCard(Player p){
    	if(content.contains(" Ò‹ÙÁÛÂ ·ıÙﬁÌ ÙÁÌ Í‹ÒÙ·")) {
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
    }
    
}