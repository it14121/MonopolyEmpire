public abstract class Brutility extends Space {
	
	public Brutility(String aName) 
	{
		super(aName);
    }
 
    public String getName()
    {
    	if (name == null) return "null";
    	return name;
    }
    
}