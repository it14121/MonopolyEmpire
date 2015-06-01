import java.util.ArrayList;


public class Player {
	
	private int code;
	private int money;	
	private Skyscraper myScyscraper;
	private int position, previousPosition;
	private ArrayList<Card> cardsInHand;
	private boolean inJail;
	
	public void Player(int aCode, int someMoney, int aPosition) {
		code = aCode;
		money = someMoney;
		myScyscraper = new Skyscraper(0);
		position = aPosition;
		cardsInHand = new ArrayList<Card>();
		inJail = false;
	}
	
	public void actOnPosition() {
		Go go = new Go();
		
		if(position == 0) {//Go
			go.passGo(this);
		} else if(position == 1 || position == 3 || position == 5 || position == 7 || 
				position == 8 || position == 10 || position == 11 || position == 13 ||
				position ==14 || position == 16 || position == 17 || position == 19 ||
				position == 20 || position == 22 || position == 23 || position == 25 ||
				position == 26 || position == 28 || position == 29 || position == 31 ||
				position == 33 || position == 35) {//Brand
			
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
			go.passGo(this);
		previousPosition = position;
	}
	
	public void addCardInHand(Card card) {
		cardsInHand.add(card);
	}
	
	public void addMoney(int m) {
		money += m;
	}
	
	public void setMoney(int m) {
		money = m;
	}
	
	public boolean hasMoney(int m) {
		if(m > money) 
			return false;
		else 
			return true;
	}
	
	public void addPosition(int pos) {
		position +=pos;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getMoney() {
		return money;
	}

	public Skyscraper getMyScyscraper() {
		return myScyscraper;
	}
	
}
