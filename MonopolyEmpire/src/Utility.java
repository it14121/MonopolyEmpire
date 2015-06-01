
public class Utility extends Brutility {
	
	private static int countElectric;
	private static int countWater;
	
	public Utility() {
		countElectric = 4;
		countWater = 4;
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
