import javax.swing.ImageIcon;


public class Empire extends Card {

	public Empire(String aName, int aTypeOfCard, int aCode, String aTitle, String aContent) {
		super(aName, aTypeOfCard, aCode, aTitle, aContent);
		icon = new ImageIcon(name + "jpg");
	}

}
