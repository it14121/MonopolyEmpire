//import javax.swing.ImageIcon;


public class Chance extends Card {

	public Chance(int aTypeOfCard, int aCode, String aTitle, String aContent) 
	{
		super(aCode, aTypeOfCard, aTitle, aContent);
		//icon = new ImageIcon(name + "ImagesGameGUI/Chance.jpg");
	}

	public boolean canKeep()
	{
		return this.typeOfCard == 1;
	}
	
}