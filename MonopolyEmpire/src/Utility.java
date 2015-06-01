
public class Utility extends Brutility {
	
	private static int countElectric;
	private static int countWater;
	
	public Utility() {
		countElectric = 4;
		countWater = 4;
	}
	
	public void decreaseElectric() {
		countElectric--;
	}
	
	public void decreaseWater() {
		countWater--;
	}
}
