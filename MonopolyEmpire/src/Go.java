
public class Go extends Space {
	
	public Go() {
		super("Go", 0);
	}
	
	public static void passGo(Player player) {
		player.addMoney(player.getMyScyscraper().getHeight());
	}

}
