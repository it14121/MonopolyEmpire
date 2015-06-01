import java.util.ArrayList;


public class Skyscraper {
	
	private int height;
	private ArrayList<Brutility> ownership;
	
	public Skyscraper(int aHeight) {
		height = aHeight;
	}
	
	public boolean isFull() {
		if(height == 800)
			return true;
		else
			return false;
	}
	
	public void addBrutility(Brutility b) {
		if(this.isFull())
			System.out.println("Sorry, but your Skyscraper is full.");// ???
		else {
			
		}
	}
	 
	public int getHeight() {
		return height;
	}
}
