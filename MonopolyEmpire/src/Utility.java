
public class Utility extends Brutility {
	
	private static int countElectric;
	private static int countWater;
	private String utilityName;
	
	public Utility(String aName) {
		super(aName);
		buyCost = 150;
		if(isTheFirst == 0) {
			isTheFirst = 1;  
			countElectric = 4;
			countWater = 4;
		}
	}
	
	public static void decreaseElectric() {
		countElectric--;
	}
	
	public static void decreaseWater() {
		countWater--;
	}
	
	public static boolean hasMoreElectric() {
		if(countElectric>0) 
			return true;
		return false;
	}

	public static boolean hasMoreWater() {
		if(countWater>0) 
			return true;
		return false;
	}
}
