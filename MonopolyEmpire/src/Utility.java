
public class Utility extends Brutility {
	
	private static int countElectric = 4;
	private static int countWater = 4;
	private String utilityName;
	
	public Utility(String aName, int aPos) {
		super(aName, aPos);
		buyCost = 150;
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
