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
import javax.swing.JOptionPane;


public class Card extends Space {
	
	private ArrayList<String> chance;
	private ArrayList<String> empire;
	private int type;
	private Random randomizer = new Random();
	ImageIcon icon = new ImageIcon("Mr.GIF");
	
	public Card(){
		
		readCards("емтокг.txt");
		readCards("аутойяатояиа.txt");
		
	}
 
    private void readCards(String name){
    	
    	try{
			FileReader fileIn = new FileReader(name);
			BufferedReader in = new BufferedReader(fileIn);
			String currentLine;
			
			while((currentLine = in.readLine()) != null){
				String line1 = currentLine;
				String line2 = in.readLine();
				String line3 = in.readLine();
				empire.add(line1 + System.lineSeparator() + line2 
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
    }
    
    
    public String getRandomCard(int type) {
    	ArrayList<String> lines;
    	if(type == 1)
    		lines = chance;
    	else
    		lines = empire;
    	Random r = new Random();
		String randomString = lines.get(r.nextInt(lines.size()));
		return randomString;
    }
    
    public void holdCard(Player p ){
    	if (p.getPosition() == 6 || p.getPosition() == 15 || p.getPosition() == 21 || p.getPosition() == 32){
    		String random = getRandomCard(1);
    		//JOptionPane.showMessageDialog(null, random, "Chance Card", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, random, "Chance Card", JOptionPane.INFORMATION_MESSAGE,icon);
    	}
    	else if(p.getPosition() == 4 || p.getPosition() == 24){
    		String random = getRandomCard(2);
    		//JOptionPane.showMessageDialog(null, random, "Empire Card", JOptionPane.INFORMATION_MESSAGE);
    		JOptionPane.showMessageDialog(null, random, "Empire Card", JOptionPane.INFORMATION_MESSAGE, icon);   	
    	}
    }
    
}