
public class Go extends Space {
	
	public Go() {
		name = "Go";
		position = 0;
	}
	
	public static void passGo(Player player) {
		player.addMoney(player.getMyScyscraper().getHeight());
	}

}
