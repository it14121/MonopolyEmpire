public class Utility extends Brutility {
	
	private  int utilitiesLeft;
	private String utilityName;
	
	public Utility(String aName) 
	{
		super(aName);
		utilitiesLeft = 4;		
	}
	
	public  boolean hasUtilities() 
	{
		return (utilitiesLeft > 0);
	}
	
	public void decreaseUtilities()
	{
		utilitiesLeft--;
	}
	
	public  void increaseUtilities() 
	{
		utilitiesLeft++;
	}
	
	public String getUtilityName()
	{
		return utilityName;
	}
		
}