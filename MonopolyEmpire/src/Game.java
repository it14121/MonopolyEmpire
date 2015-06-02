import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class Game {
	
	private ArrayList<Player> players;
	private ArrayList<Space> spaces;
	private Player activePlayer;
	private int activePlayerCode = 0; //keeps Player's code of the activePlayer for easier access, Player 0 is always first
	private Go go;
	private Brand brand;
	private Card card;
	private Utility utility;
	private Dice dice;
	
	public Game() {
		
		brand = new Brand(); //Reading Brands
		card = new Card(); //Reading Cards
		utility = new Utility(); //Initializing Utilities
		dice = new Dice(); //Create a dice

		players = new ArrayList<Player>();
        for(int i = 0; i < 4; i++){ //Initializing Players
                players.add(new Player(i));
        }
        setActivePlayer(activePlayerCode); //Set Player 0 as starting player

		
		for(int i = 0; i<=35; i++) {
			if(i == 0) {//Go
				go = new Go(); //Initializing Go
				spaces.add(go);
			} else if(i == 1 || i == 3 || i == 5 || i == 7 || 
					i == 8 || i == 10 || i == 11 || i == 13 ||
					i ==14 || i == 16 || i == 17 || i == 19 ||
					i == 20 || i == 22 || i == 23 || i == 25 ||
					i == 26 || i == 28 || i == 29 || i == 31 ||
					i == 33 || i == 35) {//Brand
				if(i == 1) {
					ArrayList<Brand> brands = brand.getBrands();
					for(int j = 0; j<=brands.size(); j++) {
						spaces.add(brands.get(j));
					}
				}
				
			} else if(i == 12 || i == 30) {//Utility 
				if(i == 12)
					spaces.add(new Utility());
				
			} else if(i == 2 || i == 34) {//TowerTax
				
			} else if(i == 4 || i == 25) {//Empire
				
			} else if(i == 6 || i == 15 || i == 21 || i == 32) {//Chance
				
			} else if(i == 9) {//JustVisiting
				
			} else if(i == 18) {//FreeParking
				
			} else if(i == 27) {//GoToJail
				
			}
		}
	}
	
	public void playerActOnPosition(Player player) {
		int position = player.getPosition();
		int previousPosition = player.getPreviousPosition();
		
		if(position == 0) {//Go
			go.passGo(player);
		} else if(position == 1 || position == 3 || position == 5 || position == 7 || 
				position == 8 || position == 10 || position == 11 || position == 13 ||
				position ==14 || position == 16 || position == 17 || position == 19 ||
				position == 20 || position == 22 || position == 23 || position == 25 ||
				position == 26 || position == 28 || position == 29 || position == 31 ||
				position == 33 || position == 35) {//Brand
			Brand brand = Brand.returnBrandWithPosition(position);
			if(brand.hawOwner()) {
				if(player.hasMoney(brand.getOwner().getMoney())) {
					player.decreaseMoney(brand.getOwner().getMoney());
				}
				else{
					// ???
				}
			}
			else {
				// ???
			}
		} else if(position == 12 || position == 30) {//Utility //??????????
			if(position == 12 && Utility.hasMoreElectric()){
				if(player.hasMoney(150)) {
					int optionPane = JOptionPane.showConfirmDialog(null, 
							"Would you like to buy the electric company?",
							"Electric Company",
							JOptionPane.YES_NO_OPTION);
					if(optionPane == JOptionPane.YES_OPTION){
						player.decreaseMoney(150);
						player.getMyScyscraper().addBrutility(new Utility());
						Utility.decreaseElectric();
					}
				}
			}
			if(position == 30 && Utility.hasMoreWater()){
				if(player.hasMoney(150)) {
					int optionPane = JOptionPane.showConfirmDialog(null, 
							"Would you like to buy the water works?",
							"Electric Company",
							JOptionPane.YES_NO_OPTION);
					if(optionPane == JOptionPane.YES_OPTION){
						player.decreaseMoney(150);
						player.getMyScyscraper().addBrutility(new Utility());
						Utility.decreaseWater();
					}
				}
			}
			
		} else if(position == 2 || position == 34) {//TowerTax
			
		} else if(position == 4 || position == 25) {//Empire
			
		} else if(position == 6 || position == 15 || position == 21 || position == 32) {//Chance
			
		} else if(position == 9) {//JustVisiting
			
		} else if(position == 18) {//FreeParking
			
		} else if(position == 27) {//GoToJail
			
		}
		
		// If the player passed GO without standing on GO.
		if( (previousPosition<=35 && previousPosition>= 25) && (position>=1 && position<=12) )
			go.passGo(player);
		player.setPreviousPosition(position);
	}
	
	public void setActivePlayer(int activePlayerCode){
        activePlayer = players.get(activePlayerCode);
    }
	
	public Player getActivePlayer(){
        return activePlayer;
    }

}
