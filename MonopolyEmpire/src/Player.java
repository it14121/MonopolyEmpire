import java.util.ArrayList;


public class Player {
	
	private int code;
	private int money;	
	private Skyscraper myScyscraper;
	private int position;
	private ArrayList<Card> cardsInHand;
	private boolean inJail;
	
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
}
