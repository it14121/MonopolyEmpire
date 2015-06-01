import java.util.ArrayList;
import javax.swing.JLayeredPane;

public class Game {
	
	private ArrayList<Player> players;
	private Go go;
	private Brand brand;
	private Card card;
	private Utility utility;
	
	public Game() {
		go = new Go(); //Initializing Go
		brand = new Brand(); //Reading Brands
		card = new Card(); //Reading Cards
		utility = new Utility(); //Initializing Utilities
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
		} else if(position == 12 || position == 30) {//Utility
			
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
	

}
