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
	
	public void addCardInHand(Card card) {
		cardsInHand.add(card);
	}
	
	public void addMoney(int m) {
		money += m;
	}
	
	public void decreaseMoney(int m) {
		money -= m;
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
	
	public int getPreviousPosition() {
		return previousPosition;
	}
	
	public int getPosition() {
		return position;
	}

	public int getMoney() {
		return money;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}

	public void setPreviousPosition(int position) {
		previousPosition = position;
	}

	public Skyscraper getMyScyscraper() {
		return myScyscraper;
	}
	
}
