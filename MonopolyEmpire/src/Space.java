import java.util.ArrayList;

public abstract class  Space {
	
	protected String name;
	protected int position;
	
	public Space(String aName) 
	{
		name = aName;
	}
	
	public Space returnTheSpaceOnPosition(int aPos, ArrayList<Space> spaces) 
	{
		return spaces.get(aPos);
	}
	
	public void actOnSpace(Player player, ArrayList<Player> players) {
		
	}
	
}