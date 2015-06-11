import java.awt.Component;
import java.awt.Dimension;
import java.util.Random; 
//import Card.ActListener;
 
 
public class Dice extends Component  {
       
	private static final long serialVersionUID = 1L;
	private int dice1;
    private int dice2; 
    private boolean isSneaky;      
    private boolean isDouble;
       
       
    public Dice() 
    {
    	//sneakySwapping = false;
    	//isDouble = false;
        setPreferredSize(new Dimension(160,100)); //-- Preferred size is set
    }
       
    public int rollTheDice() 
    {
    	dice1 = new Random().nextInt(6) + 1;
        dice2 = new Random().nextInt(6) + 1;
        isSneaky = false;
        isDouble = false;
        
     /*
      	if ( dice1 == 1 ) 
  		{
      		int optionPane = JOptionPane.showConfirmDialog(null,
                                      			"Do you want to roll a sneaky swap?",
                                       			"Message",
                                       			JOptionPane.QUESTION_MESSAGE,
                                      			JOptionPane.YES_NO_OPTION);
         	if(optionPane == JOptionPane.YES_OPTION) 
  			{
           		ArrayList<String> otherPlayersCodes = new ArrayList<String>();
            	for(int i = 0; i<=players.size(); i++) 
 				{
             		if(players.get(i).getCode() != player.getCode()) 
             		{
                 		otherPlayersCodes.add(players.get(i).getCode() + "");
                	}
            	}
            	String input = JOptionPane.showInputDialog("Write the player's code that\n "
                                              + "you want to roll a sneaky swap.");
            	while( !(otherPlayersCodes.contains(input))) 
            	{
             		input = JOptionPane.showInputDialog("Write the player's code that\n "
                                              + "you want to roll a sneaky swap.");
            	}
            	int in = Integer.parseInt(input);
            	Player otherPlayer = null;
            	for(int i = 0; i<=players.size(); i++) 
            	{
            		if(players.get(i).getCode() == in)
                		otherPlayer =  players.get(i);
            	}
            	Brutility brutilityOfPlayer =  player.getMyScyscraper().getTheTopBrutility();
            	Brutility brutilityOfOtherPlayer = otherPlayer.getMyScyscraper().getTheTopBrutility();
            	otherPlayer.getMyScyscraper().addBrutility(brutilityOfPlayer);
            	player.getMyScyscraper().addBrutility(brutilityOfOtherPlayer);
       		}
       }    
    */
        
       if (dice1 == 1) 
       {
       		isSneaky = true;
            return dice2;
       }
       else if( dice1 == dice2) isDouble = true;
       return dice1 + dice2;
	}
    
    public int getDice1() 
    {
    	return dice1;
    }
 
    public int getDice2() 
    {
    	return dice2;
    }

    public boolean isSneaky() 
    {
    	return isSneaky;
    }
       
    public boolean isDouble() 
    {
    	return isDouble;
    }
 
}