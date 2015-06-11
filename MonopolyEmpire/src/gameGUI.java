import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gameGUI extends JFrame {
       
        /**
         *
         */
	private static final long serialVersionUID = 1L;
	private static final int POS_X = 600;
	private static final int POS_Y = 635;
	private static ArrayList<Coordinates> playerPos;
	private static ArrayList<Coordinates> positions;
	private JButton rollButton;
    Game game;
    private Dice dices = new Dice();
    
    public gameGUI() 
    {
    	playerPos = initializePlayerPos();             
    	positions = initializeSpaceGUIpositions();
    	createGameGUI();
    	game = new Game();
        game.setGameFeedbackListener(new Game.GameFeedbackListener() 
        {
                                       
        	@Override
        	public void onPlayerMoved(int playerCode, int playerPosition) 
        	{                                 
        		playerMoved(playerCode, playerPosition);
        	}
        	
        	@Override
            public int onSneakyDiceRolled() 
        	{
        		return diceRolledSneaky();
        	}
 
            @Override
            public void onPlayerMovedToGO(int money) 
            {
            	playerMovedToGO(money);
            }
            
            @Override
            public void onPlayerMovedToJustVisiting() 
            {
            	playerMovedToJustVisitng();
            }
            
            @Override
			public void onPlayerMovedToGoToJail()
            {
            	playerMovedToGoToJail();
            }
            
            @Override
			public int onChooseEnemyPlayer(String message) 
            {
            	return chooseEnemyPlayer(message);
			}
            
            @Override
            public int onPlayerMovedToUtility(String utilityName, boolean hasUtilitiesLeft, boolean hasMoney, int money) 
            {
            	return playerMovedToUtility(utilityName, hasUtilitiesLeft, hasMoney, money);
			}

            @Override
			public void onPlayerMovedToBrandOwnedByHim(String name) 
            {
            	playerMovedToBrandOwnedByHim(name);
			}
            
            @Override
			public int onPlayerMovedToBrandNotOwned(String name, boolean hasMoney, int money, int cost) 
            {	
            	return playerMovedToBrandONotOwned(name, hasMoney, money, cost);
			}
            
            @Override
			public void onPlayerMovedToBrandOwnedBySomeoneElse( String name, boolean hasMoney,
														int cost, int money,
														String skyscraperName) 
            {
            	playedMovedToBrandOwnedBySomeoneElse(name, hasMoney, cost, money, skyscraperName);
			}

			@Override
			public int onPlayerMovedToFreeParking(boolean canUseFreeParking) 
			{
				return playedMovedToFreeParking(canUseFreeParking);
			}
			
			@Override
			public void onDiceCanBeRolled() 
			{
				rollButton.setEnabled(true);
			}
			
			@Override
			public void returnDiceResult(Dice dice) 
			{
				dices = dice;
			}
        });        
     
    }
       
    private void createGameGUI()
    {
    	JPanel boardPanel = new JPanel();
    	JPanel buttonPanel = new JPanel();
    	JButton exit = new JButton("Exit Game");
    	JButton newGameButton = new JButton("New Game");
    	JPanel backgroundPanel = new JPanel();
    	ImageIcon boardImage = new ImageIcon("ImagesGameGUI/Board game image.jpg");
    	backgroundPanel.add(new JLabel(boardImage));
    	backgroundPanel.setBounds(0, 0, 1024, 740);
    	ImageIcon board = new ImageIcon("ImagesGameGUI/board.jpg");
    	boardPanel.add(new JLabel(board));
    	boardPanel.setBounds(0, 0, 700, 700);
    	JPanel roll = new JPanel(){
                    /**
					 * 
					 */
		private static final long serialVersionUID = 1L;
		@Override
        public void paintComponent(Graphics g)
		{
			// The paint method draws a blue border and then
            // draws the two dice.
			Graphics2D g2 = (Graphics2D)g;  // See note below
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.DARK_GRAY);
			g2.fillRect(0, 0, getWidth(), getHeight());
			drawDie(g2, dices.getDice1(), 20, 90,1);
            drawDie(g2, dices.getDice2(), 140, 90,2);
            repaint();
        }
     };
               
     rollButton = new JButton("Roll Dices");
     rollButton.setFont(new Font("Sansserif", Font.PLAIN, 14));
     rollButton.setPreferredSize(new Dimension(120, 40));
     roll.add(rollButton, BorderLayout.NORTH);
     roll.add(dices , BorderLayout.CENTER);      
     exit.setBackground(Color.LIGHT_GRAY);
     exit.setFont(new Font("Arial", Font.BOLD, 16));
     newGameButton.setBackground(Color.lightGray);
     newGameButton.setFont(new Font("Arial", Font.BOLD, 16));
     buttonPanel.setLayout(new GridLayout(3,1));
     buttonPanel.add(newGameButton);
     buttonPanel.add(roll);
     buttonPanel.add(exit);

     rollButton.addActionListener(new ActionListener() 
     {
    	 public void actionPerformed(ActionEvent evt) 
    	 {
    		 rollActionPerformed();
         }
     });
     exit.addActionListener(new ActionListener() 
     {
    	 public void actionPerformed(ActionEvent evt) 
    	 {
    		 exitActionPerformed();
    	 }
     });
     this.add(boardPanel, BorderLayout.CENTER);
     this.add(buttonPanel, BorderLayout.LINE_END);          
     this.add(backgroundPanel, BorderLayout.CENTER);
     this.setPreferredSize(new Dimension(1024, 740));
     this.pack();
     this.setResizable(false);
     this.setVisible(true);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
       
   @Override      
   public void paint(Graphics g)
   {
	   super.paint(g);
	   //paint the 4 players
	   g.setColor(Color.RED);
	   g.fillOval(playerPos.get(0).getX(), playerPos.get(0).getY(), 20, 20);
               
	   g.setColor(Color.YELLOW);
	   g.fillOval(playerPos.get(1).getX(), playerPos.get(1).getY(), 20, 20);
               
	   g.setColor(Color.GREEN);
	   g.fillOval(playerPos.get(2).getX(), playerPos.get(2).getY() , 20, 20);
               
	   g.setColor(Color.BLUE);
	   g.fillOval(playerPos.get(3).getX() , playerPos.get(3).getY() , 20, 20);
   }
 
	void drawDie(Graphics g, int val, int x, int y,int type) 
	{
		// Draw a dice with upper left corner at (x,y).  The die is
		// 100 by 100 pixels in size.  The val parameter gives the
		// value showing on the die (that is, the number of dots).
		Graphics2D g2 = (Graphics2D)g;  // See note below
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                     RenderingHints.VALUE_ANTIALIAS_ON);
		File file= new File("ImagesGameGUI/swap.jpg");
		BufferedImage firstSwapImg = null;
        try {
        	firstSwapImg = ImageIO.read(file);
        } catch (IOException e) 
        {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        BufferedImage finalSwapImg = new BufferedImage(
                       firstSwapImg.getWidth(), firstSwapImg.getHeight(),
                      BufferedImage.TYPE_INT_ARGB);
        Graphics2D g1 = finalSwapImg.createGraphics();
        g1.drawImage(firstSwapImg, 0, 0, null);
        g1.dispose();
        int backgroundClr=  finalSwapImg.getRGB(90,98);
        int dotClr =  finalSwapImg.getRGB(94,77);
        Color backgroundColor = new Color(backgroundClr);
        Color dotColor = new Color(dotClr);
        g2.setColor(backgroundColor);
        g2.fillRect(x, y, 102, 102);
        g2.setColor(dotColor);
        g2.drawRect(x, y, 101, 101);
        if (val > 1)  // upper left dot
        	g2.fillOval(x+23, y+23, 10,10);
        if (val > 3)  // upper right dot
        	g2.fillOval(x+63, y+23, 10,10);
        if (val == 6) // middle left dot
        	g2.fillOval(x+23, y+43, 10,10);
        if (val % 2 == 1 && type == 2 || val % 2 == 1 && val != 1 && type == 1) // middle dot (for odd-numbered val's)
        	g2.fillOval(x+43, y+43, 10,10);
        if (val == 6) // middle right dot
        	g2.fillOval(x+63, y+43, 10, 10);
        if (val > 3)  // bottom left dot
        	g2.fillOval(x+23, y+63, 10, 10);
        if (val > 1)  // bottom right dot
        	g2.fillOval(x+63, y+63, 10, 10);
        if(val == 1 && type == 1)
        {
        	g2.drawImage(finalSwapImg, 21, 91, this);
        	g2.finalize();
        }
	}
	
	private void rollActionPerformed()
	{
		rollButton.setEnabled(false);
		game.playRound();
    }
       
	private void exitActionPerformed()
	{
		int flag = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		if (flag == JOptionPane.YES_OPTION) this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	public void setWindowListener(WindowListener listener)
	{
                this.addWindowListener(listener);
	}
	
	private class Coordinates{
		
		private int posX1;
		private int posY1;
		public Coordinates(int posX2, int posY2) 
		{
			posX1 = posX2;
			posY1 = posY2;
		}
               
		public int getX()
		{
			return posX1;
		}
               
		public int getY()
		{
			return posY1;
		}

		public void setCoord(Coordinates temp)
		{
			posX1 = temp.posX1;
			posY1 = temp.posY1;
		}
	}
       
    private ArrayList<Coordinates> initializePlayerPos()
    { //Creates the players on position 0.
    	ArrayList<Coordinates> aPlayerPos = new ArrayList<Coordinates>();
    	aPlayerPos.add(new Coordinates(POS_X, POS_Y));
    	aPlayerPos.add(new Coordinates(POS_X + 20, POS_Y));
    	aPlayerPos.add(new Coordinates(POS_X, POS_Y + 20));
    	aPlayerPos.add(new Coordinates(POS_X + 20, POS_Y + 20));
        return aPlayerPos;
    }
       
    private ArrayList<Coordinates> initializeSpaceGUIpositions()
    { //Creates a list with the Coordinates for each Space
    	ArrayList<Coordinates> aPositions = new ArrayList<Coordinates>();
    	int posTENx = POS_X - 9 * 58; //Position for left side of the board
    	int posTENy = POS_Y - 9 * 58; //Position for top side of the board
    	int tempPos;
        for(int i = 0; i < 9; i++)
        {
        	tempPos = i * 58;
        	aPositions.add(new Coordinates(POS_X - tempPos, POS_Y));
        }
        for(int i = 0; i < 9; i++)
        {
        	tempPos = i * 58;
        	aPositions.add(new Coordinates(posTENx, POS_Y - tempPos));
        }
        for(int i = 0; i < 9; i++)
        {
        	tempPos = i * 58;
        	aPositions.add(new Coordinates(posTENx + tempPos,posTENy));
        }
        for(int i = 0; i < 9; i++){
        	tempPos = i * 58;
        	aPositions.add(new Coordinates(POS_X, posTENy + tempPos));
        }
        return aPositions;
     }
       
	private void playerMoved(int playerCode, int playerPosition) 
	{ //Moves the player's dot to his new position
		// TODO Auto-generated method stub
		playerPos.get(playerCode).setCoord(positions.get(playerPosition));
		repaint();
	}
       
	private void playerMovedToGO(int money)
	{        
		JOptionPane.showMessageDialog(null, "You landed on GO.\nYou get "+money+"K!", "Message", JOptionPane.PLAIN_MESSAGE);            
    }
       
    private void playerMovedToJustVisitng()
    {        
    	JOptionPane.showMessageDialog(null, "You are here just for visiting.\nYou do nothing at all.", "Message", JOptionPane.PLAIN_MESSAGE);          
    }
        
    private int playedMovedToFreeParking(boolean canUseFreeParking)
    {
    	int code = -1; //-1 if the player can't travel anywhere or if he chooses not to. 0-35 for the position he chose.
    	if (canUseFreeParking)
    	{
    		int yesorno = JOptionPane.showConfirmDialog(null, "You landed on Free Parking. You can pay "+Game.FREE_PARKING_COST+"K\nto move anywhere on the map.\nIs there somewhere you would like to go?", "Message", JOptionPane.YES_NO_OPTION);
    		if (yesorno == JOptionPane.YES_OPTION)
    		{
    			do
    			{
    				code = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose where you want to go.", JOptionPane.PLAIN_MESSAGE));
    			}while(code < 0 || code > 35 || code == Game.FREE_PARKING);
    		}
    	}
    	return code;
	}
        
	private void playerMovedToGoToJail()
	{
		JOptionPane.showMessageDialog(null, "Oh no, you have landed yourself in jail!\n", "Message", JOptionPane.PLAIN_MESSAGE);        
	}
       
	private int playerMovedToUtility(String utilityName, boolean hasUtilitiesLeft, boolean hasMoney, int money)
	{
		int yesorno = 0;
		if(!(hasUtilitiesLeft))
		{ // There are no utilities left
			JOptionPane.showMessageDialog(null, "You landed on "+utilityName+".\nThere are no utilities left.\nYou do nothing.", "Message", JOptionPane.PLAIN_MESSAGE);
		}
		else if(!(hasMoney))
		{ 
			JOptionPane.showMessageDialog(null, "You landed on "+utilityName+".\nTYou have no money to buy a utility.\nYou do nothing.", "Message", JOptionPane.PLAIN_MESSAGE);
		}
		else 
		{
			yesorno = JOptionPane.showConfirmDialog(null, "You landed on "+utilityName+".\nYou have "+money+"K and a utility costs "+Game.UTILITY_COST+"K\n Do you want to buy?", "Message", JOptionPane.YES_NO_OPTION);
		}
        return yesorno;
    }
       
	private int diceRolledSneaky()
	{
		int optionPane = JOptionPane.showConfirmDialog(null,
                                         "Do you want to roll a sneaky swap?",
                                         "Message",
                                         JOptionPane.YES_NO_OPTION,
                                         JOptionPane.QUESTION_MESSAGE);
         if(optionPane == JOptionPane.YES_OPTION)
         {
        	 return Game.DICE_YES;
         }
         else
         {
        	 return Game.DICE_NO;
         }
	}
       
	private int chooseEnemyPlayer(String message)
	{
		return Integer.parseInt(JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE));          
		//returns an integer which is used as the code of the enemy player. If the input is not appropriate that is handled in the function who called this function
	}
       
	private void playerMovedToBrandOwnedByHim(String name)
	{
		JOptionPane.showMessageDialog(null, "You landed on "+name+".\nIt's owned by you.\nYou do nothing.", "Message", JOptionPane.PLAIN_MESSAGE);        
	}
        
	private int playerMovedToBrandONotOwned(String name, boolean hasMoney, int money, int cost)
	{
		int yesorno = 0;
		if (hasMoney)
		{
			yesorno =  JOptionPane.showConfirmDialog(null, "You landed on "+name+".\nIt costs "+cost+"K and you have "+money+"K.\n Do you want to buy it?", "Message", JOptionPane.YES_NO_OPTION);
        }
        else 
        {
        	JOptionPane.showMessageDialog(null, "You landed on "+name+".\nYou do not have enough money to buy it.\nYou do nothing.", "Message", JOptionPane.PLAIN_MESSAGE);
        }
		return yesorno;
	}
        
	private void playedMovedToBrandOwnedBySomeoneElse(String name, boolean hasMoney, int cost, int money, String skyscraperName)
	{
		if (hasMoney)
		{
			JOptionPane.showMessageDialog(null, "You landed on "+name+".\nIt's owned by someone else.\nYou pay them "+cost+"and are left with "+money+"K.", "Message", JOptionPane.PLAIN_MESSAGE);      
		}
		else if (skyscraperName != null)
		{
			JOptionPane.showMessageDialog(null, "You landed on "+name+".\nIt's owned by someone else.\nYou do not have enough money to pay.\nYou give them "+skyscraperName, "Message", JOptionPane.PLAIN_MESSAGE);      
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "You landed on "+name+".\nYou do not have enough money to pay and your skyscraper is empty.\nYou get to go for free, things are already hard for you!", "Message", JOptionPane.PLAIN_MESSAGE);
		}
	}
 
}