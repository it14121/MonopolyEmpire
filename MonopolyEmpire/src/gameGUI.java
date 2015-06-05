import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
 


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
       
        private static final int posX = 600;
        private static final int posY = 635;
       
        //private int tempI = 0;
        //private static Player activePlayer;
        private static ArrayList<Coordinates> playerPos;
        private static ArrayList<Coordinates> positions;
       
        public gameGUI() {
               
                Game game = new Game();
                game.setGameFeedbackListener(new Game.GameFeedbackListener() {
					
					@Override
					public void onPlayerMoved(int playerCode, int playerPosition) {
						// TODO Auto-generated method stub
						playerMoved(playerCode, playerPosition);
					}
					
					@Override
					public void moveOnJustVisiting() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onMovedToBrand() {
						// TODO Auto-generated method stub
						movedOnBrand();
					}

					@Override
					public int onDiceRolled(int code) {
						// TODO Auto-generated method stub
						// Code 1 for isSeanky = true
						
						if(code == Game.IS_SNEAKY) diceRolledSneaky();
						
						
					}

					

					

				
					
				
				});        
                playerPos = initializePlayerPos();             //Will probably have to make it so that the methods run if we remove players from the list (if one loses)
                positions = initializeSpaceGUIpositions();
                createGameGUI();
               
                //activePlayer = game.getActivePlayer();
              
                
               
        }
       
        private void createGameGUI(){
               
                //mainGame = new JFrame();
                JPanel boardPanel = new JPanel();
                JPanel buttonPanel = new JPanel();
                ImageIcon dices = new ImageIcon("dices.png");
                JButton roll = new JButton(dices);
                JButton exit = new JButton("Exit Game");
                JButton newGameButton = new JButton("New Game");
                JPanel backgroundPanel = new JPanel();
                       
                ImageIcon boardImage = new ImageIcon("Board game image.jpg");
                backgroundPanel.add(new JLabel(boardImage));
                backgroundPanel.setBounds(0, 0, 1024, 740);
                ImageIcon board = new ImageIcon("board.jpg");
                boardPanel.add(new JLabel(board));
                boardPanel.setBounds(0, 0, 700, 700);
                       

                       
                   
                exit.setBackground(Color.LIGHT_GRAY);
                exit.setFont(new Font("Arial", Font.BOLD, 16));
                newGameButton.setBackground(Color.lightGray);
                newGameButton.setFont(new Font("Arial", Font.BOLD, 16));
                buttonPanel.setLayout(new GridLayout(3,1));
                buttonPanel.add(newGameButton);
                buttonPanel.add(roll);
                buttonPanel.add(exit);
                       
                       
                       
                roll.addActionListener(new ActionListener() {
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
//                	posX1 = posX - times * 58;
//                }
//                
//                public void resetY(int times){
//                	posY1 = posY - times * 58;
//                }
                
                public void setCoord(Coordinates temp){
                	posX1 = temp.posX1;
                	posY1 = temp.posY1;
                }
        }
       
        private ArrayList<Coordinates> initializePlayerPos(){ //Creates the players on position 0.
               
                ArrayList<Coordinates> aPlayerPos = new ArrayList<Coordinates>();
                aPlayerPos.add(new Coordinates(posX, posY));
                aPlayerPos.add(new Coordinates(posX + 20, posY));
                aPlayerPos.add(new Coordinates(posX, posY + 20));
                aPlayerPos.add(new Coordinates(posX + 20, posY + 20));
               
                //System.out.println("Coordinates for position 0 \nX Coordinate: " + posX + "\nY Coordinate: " + posY);
                
                return aPlayerPos;
        }
        
        private ArrayList<Coordinates> initializeSpaceGUIpositions(){ //Creates a list with the Coordinates for each Space 
        	
        	ArrayList<Coordinates> aPositions = new ArrayList<Coordinates>();
        	int posTENx = posX - 9 * 58; //Position for left side of the board
        	int posTENy = posY - 9 * 58; //Position for top side of the board
        	
//        	for(int i = 0; i<9; i++){
//        		int tempPos = i * 58;
//        		aPositions.add(i, new Coordinates(posX - tempPos, posY));
//        		aPositions.add(i+9, new Coordinates(posTEN, posY - tempPos));
//        		aPositions.add(i+2*9, new Coordinates(posTEN + tempPos,posTEN));
//        		aPositions.add(i+3*9, new Coordinates(posX, posTEN + tempPos));
//        	}
        	int tempPos;
        	for(int i = 0; i < 9; i++){
        		tempPos = i * 58;
        		aPositions.add(new Coordinates(posX - tempPos, posY));
        	}
        	for(int i = 0; i < 9; i++){
        		tempPos = i * 58;
        		aPositions.add(new Coordinates(posTENx, posY - tempPos));
        	}
        	for(int i = 0; i < 9; i++){
        		tempPos = i * 58;
        		aPositions.add(new Coordinates(posTENx + tempPos,posTENy));
        	}
        	for(int i = 0; i < 9; i++){
        		tempPos = i * 58;
        		aPositions.add(new Coordinates(posX, posTENy + tempPos));
        	}
        	return aPositions;
        }
        
        public void playerMoved(int playerCode, int playerPosition) { //Moves the player's dot to his new position
			// TODO Auto-generated method stub
        	playerPos.get(playerPosition).setCoord(positions.get(playerPosition));
        	repaint();
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
        
        
        private int diceRolledSneakyIsYES(){
        	return Integer.parseInt(JOptionPane.showInputDialog(null, "Choose a player to swap with other than yourself", "Message", JOptionPane.PLAIN_MESSAGE));
        	JOptionPane.
         
        	
        }
        
        public void movedOnBrand(){
        	
        }
 
}