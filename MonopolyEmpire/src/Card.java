import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Card extends Space {
	
	private List<String> chance;
	private List<String> empire;
	private int type;
	private Random randomizer = new Random();
	
	public void readChance(){
		Scanner s;
		try {
			s = new Scanner(new File("емтокг.odt"));
			chance = new ArrayList<String>();
			while (s.hasNextLine()){
			    chance.add(s.nextLine());
			}
			s.close();
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	}
	
    public void readEmpire(){
    	Scanner s;
		try {
			s = new Scanner(new File("аутойяатояиа.odt"));
			chance = new ArrayList<String>();
			while (s.hasNextLine()){
			    empire.add(s.nextLine());
			}
			s.close();
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
    	
    }
    
    public void holdCard(Player p ){
    	if (p.getPosition() == 6 || p.getPosition() == 15 || p.getPosition() == 21 || p.getPosition() == 32){
    		String random = chance.get(randomizer.nextInt(chance.size()));
    		JOptionPane.showMessageDialog(null, random, "Chance Card", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if(p.getPosition() == 4 || p.getPosition() == 24){
    		String random = empire.get(randomizer.nextInt(empire.size()));
    		JOptionPane.showMessageDialog(null, random, "Empire Card", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
    
    public void getCard(int type){
    	if (type == 1 ){
    		
    	}
    	else if(type == 2){
    		
    	}
    }
}

