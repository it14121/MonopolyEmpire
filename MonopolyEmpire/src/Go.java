
public class Go extends Space {
	
	public Go() {
	}
	
	public static void passGo(Player player) {
		player.addMoney(player.getMyScyscraper().getHeight());
	}

}
