public class Go extends Space {

	public Go() 
	{
     	super("Go");
    }
       
    public static int  passGo(Player player) 
    {
    	int money = player.getSkyscraper().getHeight();
        player.addMoney(money);
        return money;
    }
 
}