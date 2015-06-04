import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
 
public class gameGUI extends JFrame implements MouseListener{
       
        /**
         *
         */
        private static final long serialVersionUID = 1L;
       // private JFrame mainGame;
       
        private  int posX = 600;
        private  int posY = 635;
       
        //private int tempI = 0;
        private static Player activePlayer;
        private static ArrayList<Coordinates> playerPos;
        private static ArrayList<Coordinates> positions;
       
        public gameGUI() {
               
                Game game = new Game();
                        
                playerPos = initializePlayerPos();
                positions = initializePositions();
                createGameGUI();
               
                activePlayer = game.getActivePlayer();
                
               
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
                       
                       
                //roll.setBackground(Color.RED);
                //roll.setFont(new Font("Arial", Font.BOLD, 16));
                       
                   
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
               
       
                addMouseListener(this);  //For testing purposes only
               
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
        
        public void movePlayer(){
        	playerPos.get(activePlayer.getCode()).setCoord(positions.get(activePlayer.getPosition()));
        }
//        public void movePlayer(int roll){
//               
//               
//                int previousPosition = activePlayer.getPosition();
//                int newPosition = (previousPosition + roll) % 35;
//               
//                activePlayer.setPreviousPosition(previousPosition);
//                activePlayer.setPosition(newPosition);
//                            
//                int posDifference = newPosition - previousPosition;
//               
//                System.out.println("\n\n--- NEW ENTRY ---");
//                System.out.println("Previous Position: " + previousPosition);
//                System.out.println("New Position: " + newPosition);
//                System.out.println("Position Difference: " + posDifference);
//                
//                int posDifferencePerc = (newPosition-1) / 9 - (previousPosition-1) / 9;
//                if (posDifference > 0){
//                        
//                        System.out.println("Position Difference Percentage: " + posDifferencePerc);
//                        if(posDifferencePerc == 0){ //Η ευθεία δεν έχει αλλάξει
//                                if (newPosition == 0){ // παίκτης γύρισε πίσω στην αφετηρία. Το newPosition γίνεται 0 από 35
//                                        moveOnSameLine(3, posDifference); // κι αυτό χαλάει το posDifferencePerc (-1 αντί για 3)
//                                }
//                                else{
//                                        int line = (newPosition - 1) / 9;                              
//                                        moveOnSameLine(line, posDifference);
//                                }
//                               
//                        }
//                        else if (posDifferencePerc == 1) {
//                                if (newPosition < 10) newPosition = 35;
//                               
//                                int line = (newPosition - 1) / 9;
//                                int distanceOnNewLine = newPosition - ((line) * 9);
//                                int distanceOnOldLine = ((line) * 9) - previousPosition;
//                                moveOnDifferentLine(line, distanceOnNewLine, distanceOnOldLine);
//                        }
//                        else if (posDifferencePerc == 2){
//                                int line = (newPosition - 1) / 9;
//                               
//                                int prevDist = previousPosition - (previousPosition / 9)*9;
//                                int newDist = newPosition - (newPosition / 9-1)*9;
//                                int coordDistance = prevDist + newDist;
//                               
//                                moveAcrossBoard(line, coordDistance);
//                               
//                        }
//                }
//                else {
//                	if (newPosition < 10) {
//                		playerPos.get(activePlayer.getCode()).resetX(newPosition);
//                		playerPos.get(activePlayer.getCode()).resetY(0);
//                	
//                	}
//                	else{
//                		playerPos.get(activePlayer.getCode()).resetX(9);
//                		playerPos.get(activePlayer.getCode()).resetY(newPosition-9);
//                	}
//                }
//               
//                System.out.println("Players X Coordinate: " + playerPos.get(activePlayer.getCode()).getX());
//                System.out.println("Players Y Coordinate: " + playerPos.get(activePlayer.getCode()).getY());
//                repaint();
//        }
//        private void moveOnSameLine(int line, int posDifference){
//                if (line == 0 ){
//                        playerPos.get(activePlayer.getCode()).setX(posDifference);
//                }
//                else if(line == 1){
//                        playerPos.get(activePlayer.getCode()).setY(posDifference);
//                }
//                else if(line == 2){
//                        playerPos.get(activePlayer.getCode()).setX(-posDifference);
//                }
//                else if(line == 3){
//                        playerPos.get(activePlayer.getCode()).setY(-posDifference);
//                }
//                else System.out.println("ERROR 1 ");
//               
//        }
//        private void moveAcrossBoard(int line, int coordDistance){
//                if (line == 0 ){
//                        playerPos.get(activePlayer.getCode()).setY(9);
//                        playerPos.get(activePlayer.getCode()).setX(coordDistance);
//                }
//                else if(line == 1){
//                        playerPos.get(activePlayer.getCode()).setX(9);
//                        playerPos.get(activePlayer.getCode()).setY(coordDistance);
//                }
//                else if(line == 2){
//                        playerPos.get(activePlayer.getCode()).setY(-9);
//                        playerPos.get(activePlayer.getCode()).setX(coordDistance);
//                }
//                else if(line == 3){
//                        playerPos.get(activePlayer.getCode()).setX(-9);
//                        playerPos.get(activePlayer.getCode()).setY(coordDistance);
//                }
//                else System.out.println("ERROR 1 ");
//        }
//       
//        private void moveOnDifferentLine(int line, int distanceOnNewLine, int distanceOnOldLine){
//               
//                if (line == 0 ){
//                        playerPos.get(activePlayer.getCode()).setX(distanceOnNewLine);
//                        playerPos.get(activePlayer.getCode()).setY(-(36+distanceOnOldLine));
//                }
//                else if(line == 1){            
//                        playerPos.get(activePlayer.getCode()).setY(distanceOnNewLine);
//                        playerPos.get(activePlayer.getCode()).setX(distanceOnOldLine);
//                }
//                else if(line == 2){
//                        playerPos.get(activePlayer.getCode()).setX(-distanceOnNewLine);
//                        playerPos.get(activePlayer.getCode()).setY(distanceOnOldLine);
//                }
//                else if(line == 3){
//                        playerPos.get(activePlayer.getCode()).setY(-distanceOnNewLine);
//                        playerPos.get(activePlayer.getCode()).setX(-distanceOnOldLine);
//                }
//                else System.out.println("ERROR 2");
//        }
       
        
        
        private void rollActionPerformed(){
               
               
               
        }
       
        private void exitActionPerformed(){
               
                int flag = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (flag == JOptionPane.YES_OPTION) this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
               
        }
        public void setWindowListener(WindowListener listener){
                this.addWindowListener(listener);
        }
       
        //For testing purposes only (all mouse functions)
        public void mouseClicked(MouseEvent e) {

         movePlayer();
         repaint();
         
            }
 
        @Override
        public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub
               
        }
 
        @Override
        public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
               
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
       
        private ArrayList<Coordinates> initializePlayerPos(){
               
                ArrayList<Coordinates> aPlayerPos = new ArrayList<Coordinates>();
                aPlayerPos.add(new Coordinates(posX, posY));
                aPlayerPos.add(new Coordinates(posX + 20, posY));
                aPlayerPos.add(new Coordinates(posX, posY + 20));
                aPlayerPos.add(new Coordinates(posX + 20, posY + 20));
               
                //System.out.println("Coordinates for position 0 \nX Coordinate: " + posX + "\nY Coordinate: " + posY);
                
                return aPlayerPos;
        }
        
        private ArrayList<Coordinates> initializePositions(){
        	
        	ArrayList<Coordinates> aPositions = new ArrayList<Coordinates>(35);
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
        
        
 
}