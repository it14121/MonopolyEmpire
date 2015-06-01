
public class Brand extends Brutility {
	
	private String color;
	private int owner = 0;
	
	public Brand(String aColor, String aName, int  aPosition, int aBuyCost) {
		color = aColor;
		name = aName;
		position = aPosition;
		buyCost = aBuyCost;
	}
	
	public boolean hawOwner() {
		if(owner == 0)
			return false;
		else
			return true;
	}
	
	public void setOwner(Player p) {
		if((p.getMoney()>= this.buyCost) )/// ???
			owner = p.getCode();
		else
			System.out.println("Sorry, but player " + p.getCode() + " cannot buy this brand!");
	}
	
	public int getOwner() {
		return owner;
	}
	
	public String getColor() {
		return color.toString();
	}
	
	
	
	
}
