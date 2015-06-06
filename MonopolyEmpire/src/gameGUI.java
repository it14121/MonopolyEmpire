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
import java.util.ArrayList;
 
 
 
 
 


import javax.swing.BorderFactory;
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
       // private JFrame mainGame;
       
        private static final int POS_X = 600;
        private static final int POS_Y = 635;
       
        //private int tempI = 0;
        //private static Player activePlayer;
        private static ArrayList<Coordinates> playerPos;
        private static ArrayList<Coordinates> positions;
       
        private Dice leftDice = new Dice();
        private Dice rightDice = new Dice();
        private int faceValue;
        private int faceLeftValue;
        private int faceRightValue;
        private static final int SPOT_DIAM = 9;  // Diameter of spots
       
        public gameGUI() {
               
        	playerPos = initializePlayerPos();             
            positions = initializeSpaceGUIpositions();
            createGameGUI();
               
               Game game = new Game();
               game.setGameFeedbackListener(new Game.GameFeedbackListener() {
                                       
                                        @Override
                                        public void onPlayerMoved(int playerCode, int playerPosition) {
                                                // TODO Auto-generated method stub
                                                playerMoved(playerCode, playerPosition);
                                               
                                                try {
                                                        this.wait(500);
                                                } catch (InterruptedException e) {
                                                        // TODO Auto-generated catch block
                                                        e.printStackTrace();
                                                }
                                               
                                               
                                        }
                                       
                                                               
 
                                      
 
                                        @Override
                                        public int onSneakyDiceRolled() {
                                                // TODO Auto-generated method stub
                                                // Code 1 for isSeanky = true
                                               
                                                return diceRolledSneaky();
//                                                if(code == Game.IS_SNEAKY_YES) chooseEnemyPlayer("Choose a player to swap with other than yourself");
                                               
                                               
                                               
                                        }
 
                                        @Override
                                        public void onPlayerMovedToGO(int money) {
                                                // TODO Auto-generated method stub
                                                playerMovedToGO(money);
                                       
                                        }
 
 
 
 
                                        @Override
                                        public void onPlayerMovedToJustVisiting() {
                                                // TODO Auto-generated method stub
                                                playerMovedToJustVisitng();
                                               
                                        }



										@Override
										public void onPlayerMovedToGoToJail() {
											// TODO Auto-generated method stub
											playerMovedToGoToJail();
											
										}



										@Override
										public int onChooseEnemyPlayer(String message) {
											// TODO Auto-generated method stub
											return chooseEnemyPlayer(message);
										}



										@Override
										public int onPlayerMovedToUtility(String utilityName, boolean hasUtilitiesLeft, boolean hasMoney, int money) {
											// TODO Auto-generated method stub
											
											return playerMovedToUtility(utilityName, hasUtilitiesLeft, hasMoney, money);
										}



										@Override
										public void onPlayerMovedToBrandOwnedByHim(String name) {
											// TODO Auto-generated method stub
											playerMovedToBrandOwnedByHim(name);
										}





										@Override
										public int onPlayerMovedToBrandNotOwned(String name, boolean hasMoney, int money, int cost) {
											// TODO Auto-generated method stub
											return playerMovedToBrandONotOwned(name, hasMoney, money, cost);
										}





										@Override
										public void onPlayerMovedToBrandOwnedBySomeoneElse(
												String name, boolean hasMoney,
												int cost, int money,
												String skyscraperName) {
											// TODO Auto-generated method stub
											playedMovedToBrandOwnedBySomeoneElse(name, hasMoney, cost, money, skyscraperName);
										}
 
               
                                });        
               
 
                               
                                       
                               
                       
 
 
               
                //activePlayer = game.getActivePlayer();
             
               
               
        }
       
        private void createGameGUI(){
               
                //mainGame = new JFrame();
                JPanel boardPanel = new JPanel();
                JPanel buttonPanel = new JPanel();
                //ImageIcon dices = new ImageIcon("dices.png");
                JPanel roll = new JPanel();
                JButton exit = new JButton("Exit Game");
                JButton newGameButton = new JButton("New Game");
                JPanel backgroundPanel = new JPanel();
                       
                ImageIcon boardImage = new ImageIcon("Board game image.jpg");
                backgroundPanel.add(new JLabel(boardImage));
                backgroundPanel.setBounds(0, 0, 1024, 740);
                ImageIcon board = new ImageIcon("board.jpg");
                boardPanel.add(new JLabel(board));
                boardPanel.setBounds(0, 0, 700, 700);
                       
                JButton rollButton = new JButton("New Roll");
                rollButton.setFont(new Font("Sansserif", Font.PLAIN, 24));
                roll.setLayout(new BorderLayout(5, 5));
                roll.add(rollButton, BorderLayout.NORTH);
                roll.add(leftDice , BorderLayout.WEST);
                roll.add(rightDice, BorderLayout.EAST);
               
                roll.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));      
                   
                exit.setBackground(Color.LIGHT_GRAY);
                exit.setFont(new Font("Arial", Font.BOLD, 16));
                newGameButton.setBackground(Color.lightGray);
                newGameButton.setFont(new Font("Arial", Font.BOLD, 16));
                buttonPanel.setLayout(new GridLayout(3,1));
                buttonPanel.add(newGameButton);
                buttonPanel.add(roll);
                buttonPanel.add(exit);
                       
                   
                       
 
                       
 
               
                rollButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                rollActionPerformed();
                        }
                        });
               
               
               
                exit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
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
        public void paint(Graphics g){
               
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
 
     
       
        public void setLeftValue() {
            faceLeftValue = leftDice.getDice1();
            repaint();    // Value has changed, must repaint
        }
       
        public void setRightValue() {
            faceRightValue = rightDice.getDice1();
            repaint();    // Value has changed, must repaint
        }
       
        public void paintComponent(Graphics g) {
            int w = getWidth();  // Get height and width
            int h = getHeight();
           
            //... Change to Graphic2D for smoother spots.
            Graphics2D g2 = (Graphics2D)g;  // See note below
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
           
           
            //... Paint background
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, w, h);
            g2.setColor(Color.WHITE);
           
            g2.drawRect(0, 0, w-1, h-1);  // Draw border
           
           
           
            switch (faceLeftValue) {
                case 1:
                    drawSpot(g2, w/2, h/2);
                    break;
                case 3:
                    drawSpot(g2, w/2, h/2);
                    // Fall thru to next case
                case 2:
                    drawSpot(g2, w/4, h/4);
                    drawSpot(g2, 3*w/4, 3*h/4);
                    break;
                case 5:
                    drawSpot(g2, w/2, h/2);
                    // Fall thru to next case
                case 4:
                    drawSpot(g2, w/4, h/4);
                    drawSpot(g2, 3*w/4, 3*h/4);
                    drawSpot(g2, 3*w/4, h/4);
                    drawSpot(g2, w/4, 3*h/4);
                    break;
                case 6:
                    drawSpot(g2, w/4, h/4);
                    drawSpot(g2, 3*w/4, 3*h/4);
                    drawSpot(g2, 3*w/4, h/4);
                    drawSpot(g2, w/4, 3*h/4);
                    drawSpot(g2, w/4, h/2);
                    drawSpot(g2, 3*w/4, h/2);
                    break;
            }
           
            switch (faceRightValue) {
            case 1:
                drawSpot(g2, w/2, h/2);
                break;
            case 3:
                drawSpot(g2, w/2, h/2);
                // Fall thru to next case
            case 2:
                drawSpot(g2, w/4, h/4);
                drawSpot(g2, 3*w/4, 3*h/4);
                break;
            case 5:
                drawSpot(g2, w/2, h/2);
                // Fall thru to next case
            case 4:
                drawSpot(g2, w/4, h/4);
                drawSpot(g2, 3*w/4, 3*h/4);
                drawSpot(g2, 3*w/4, h/4);
                drawSpot(g2, w/4, 3*h/4);
                break;
            case 6:
                drawSpot(g2, w/4, h/4);
                drawSpot(g2, 3*w/4, 3*h/4);
                drawSpot(g2, 3*w/4, h/4);
                drawSpot(g2, w/4, 3*h/4);
                drawSpot(g2, w/4, h/2);
                drawSpot(g2, 3*w/4, h/2);
                break;
        }
        }
       
        private void drawSpot(Graphics2D g2, int x, int y) {
            g2.fillOval(x-SPOT_DIAM/2, y-SPOT_DIAM/2, SPOT_DIAM, SPOT_DIAM);
 
        }
               
 
       
       
                       
        private void rollActionPerformed(){
               
               
               
        }
       
        private void exitActionPerformed(){
               
                int flag = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (flag == JOptionPane.YES_OPTION) this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
               
        }
        public void setWindowListener(WindowListener listener){
                this.addWindowListener(listener);
        }
       
       
       
        private class Coordinates{
                private int posX1;
                private int posY1;
                public Coordinates(int posX2, int posY2) {
                        posX1 = posX2;
                        posY1 = posY2;
                }
               
                public int getX(){
                        return posX1;
                }
               
                public int getY(){
                        return posY1;
                }
               
//                public void setX(int times){
//                        posX1 = posX1 - times * 58;
//                }
//              
//              
//                public void setY(int times){
//                        posY1 = posY1 - times * 58;
//                }
//                
//                public void resetX(int times){
//                      posX1 = posX - times * 58;
//                }
//                
//                public void resetY(int times){
//                      posY1 = posY - times * 58;
//                }
               
                public void setCoord(Coordinates temp){
                        posX1 = temp.posX1;
                        posY1 = temp.posY1;
                }
        }
       
        private ArrayList<Coordinates> initializePlayerPos(){ //Creates the players on position 0.
               
                ArrayList<Coordinates> aPlayerPos = new ArrayList<Coordinates>();
                aPlayerPos.add(new Coordinates(POS_X, POS_Y));
                aPlayerPos.add(new Coordinates(POS_X + 20, POS_Y));
                aPlayerPos.add(new Coordinates(POS_X, POS_Y + 20));
                aPlayerPos.add(new Coordinates(POS_X + 20, POS_Y + 20));
               
                //System.out.println("Coordinates for position 0 \nX Coordinate: " + posX + "\nY Coordinate: " + posY);
               
                return aPlayerPos;
        }
       
        private ArrayList<Coordinates> initializeSpaceGUIpositions(){ //Creates a list with the Coordinates for each Space
               
                ArrayList<Coordinates> aPositions = new ArrayList<Coordinates>();
                int posTENx = POS_X - 9 * 58; //Position for left side of the board
                int posTENy = POS_Y - 9 * 58; //Position for top side of the board
               
//              for(int i = 0; i<9; i++){
//                      int tempPos = i * 58;
//                      aPositions.add(i, new Coordinates(posX - tempPos, posY));
//                      aPositions.add(i+9, new Coordinates(posTEN, posY - tempPos));
//                      aPositions.add(i+2*9, new Coordinates(posTEN + tempPos,posTEN));
//                      aPositions.add(i+3*9, new Coordinates(posX, posTEN + tempPos));
//              }
                int tempPos;
                for(int i = 0; i < 9; i++){
                        tempPos = i * 58;
                        aPositions.add(new Coordinates(POS_X - tempPos, POS_Y));
                }
                for(int i = 0; i < 9; i++){
                        tempPos = i * 58;
                        aPositions.add(new Coordinates(posTENx, POS_Y - tempPos));
                }
                for(int i = 0; i < 9; i++){
                        tempPos = i * 58;
                        aPositions.add(new Coordinates(posTENx + tempPos,posTENy));
                }
                for(int i = 0; i < 9; i++){
                        tempPos = i * 58;
                        aPositions.add(new Coordinates(POS_X, posTENy + tempPos));
                }
                return aPositions;
        }
       
        private void playerMoved(int playerCode, int playerPosition) { //Moves the player's dot to his new position
                        // TODO Auto-generated method stub
                playerPos.get(playerPosition).setCoord(positions.get(playerPosition));
                repaint();
                }
       
        private void playerMovedToGO(int money){        
                JOptionPane.showMessageDialog(null, "You landed on GO.\nYou get "+money+"K!", "Message", JOptionPane.PLAIN_MESSAGE);            
        }
       
        private void playerMovedToJustVisitng(){        
                JOptionPane.showMessageDialog(null, "You are here just for visiting.\nYou do nothing at all.", "Message", JOptionPane.PLAIN_MESSAGE);          
        }
        
        private void playerMovedToGoToJail(){
        	 JOptionPane.showMessageDialog(null, "Oh no, you have landed yourself in jail!\n", "Message", JOptionPane.PLAIN_MESSAGE);        
        }
       
        private int playerMovedToUtility(String utilityName, boolean hasUtilitiesLeft, boolean hasMoney, int money){
        	int yesorno = 0;
        	if(!(hasUtilitiesLeft)){ // There are no utilities left
        		JOptionPane.showMessageDialog(null, "You landed on "+utilityName+".\nThere are no utilities left.\nYou do nothing.", "Message", JOptionPane.PLAIN_MESSAGE);
        	}
        	else if(!(hasMoney)){ 
        		JOptionPane.showMessageDialog(null, "You landed on "+utilityName+".\nTYou have no money to buy a utility.\nYou do nothing.", "Message", JOptionPane.PLAIN_MESSAGE);
        	}
        	else {
        		
        		yesorno = JOptionPane.showConfirmDialog(null, "You landed on "+utilityName+".\nYou have "+money+"K and a utility costs 150K\n Do you want to buy?", "Message", JOptionPane.YES_NO_OPTION);
        	}
        	return yesorno;
        }
       
        private int diceRolledSneaky(){
       
                int optionPane = JOptionPane.showConfirmDialog(null,
                                         "Do you want to roll a sneaky swap?",
                                         "Message",
                                         JOptionPane.QUESTION_MESSAGE,
                                         JOptionPane.YES_NO_OPTION);
                         if(optionPane == JOptionPane.YES_OPTION){
                                 return Game.DICE_YES;
                         }
                         else{
                                 return Game.DICE_NO;
                         }
                         
                         
        }
       
       
        private int chooseEnemyPlayer(String message){
                return Integer.parseInt(JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE));          
                //returns an integer which is used as the code of the enemy player. If the input is not appropriate that is handled in the function who called this function
        }
       
        private void playerMovedToBrandOwnedByHim(String name){
        	JOptionPane.showMessageDialog(null, "You landed on "+name+".\nIt's owned by you.\nYou do nothing.", "Message", JOptionPane.PLAIN_MESSAGE);        
        }
        
        private int playerMovedToBrandONotOwned(String name, boolean hasMoney, int money, int cost){
        	int yesorno = 0;
        	if (hasMoney){
        		yesorno =  JOptionPane.showConfirmDialog(null, "You landed on "+name+".\nIt costs "+cost+"K and you have "+money+"K.\n Do you want to buy it?", "Message", JOptionPane.YES_NO_OPTION);
        	}
        	else {
        		 JOptionPane.showMessageDialog(null, "You landed on "+name+".\nYou do not have enough money to buy it.\nYou do nothing.", "Message", JOptionPane.YES_NO_OPTION);
        	}
        	return yesorno;
        }
        
        private void playedMovedToBrandOwnedBySomeoneElse(String name, boolean hasMoney, int cost, int money, String skyscraperName){
        	if (hasMoney){
        		JOptionPane.showMessageDialog(null, "You landed on "+name+".\nIt's owned by someone else.\nYou pay them "+cost+"and are left with "+money+"K.", "Message", JOptionPane.PLAIN_MESSAGE);      
        	}
        	else if (skyscraperName != null){
        		JOptionPane.showMessageDialog(null, "You landed on "+name+".\nIt's owned by someone else.\nYou do not have enough money to pay.\nYou give them "+skyscraperName, "Message", JOptionPane.PLAIN_MESSAGE);      
        	}
        	else {
        		 JOptionPane.showMessageDialog(null, "You landed on "+name+".\nYou do not have enough money to pay and your skyscraper is empty.\nYou get to go for free, things are already hard for you!", "Message", JOptionPane.PLAIN_MESSAGE);
        	}
        }
 
}