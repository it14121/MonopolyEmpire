import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
 

 
//import Card.ActListener;
 
public class Game {
       
        private ArrayList<Player> players;
        private ArrayList<Space> spaces;
        private Player activePlayer;
        //private int activePlayerCode = 0; //keeps Player's code of the activePlayer for easier access, Player 0 is always first
        private Go go;
        private Brand brand;
        private ArrayList<Empire> empires;
        private ArrayList<Chance> chances;
        private Dice dice;
       
        public static final int DICE_YES = -1;
        public static final int DICE_NO = -2;
        
        public static final int IS_SNEAKY = -1;
        public static final int IS_SNEAKY_YES = -2;
        
        private static final int RIVAL_TOWER_TAX = 2;
        private static final int JUST_VISITING = 9;
        private static final int ELECTRIC_UTILITY = 12;
        private static final int FREE_PARKING = 18;
        private static final int GO_TO_JAIL = 27;
        private static final int WATER_UTILITY = 30;
        private static final int TOWER_TAX = 34;
        
        private static final int FREE_PARKING_COST = 100;
        private static final int UTILITY_COST = 150;
        
       
        public Game() {
               
                //brand = new Brand(null); //Reading Brands
                this.readCards("Empire"); //Reading Cards
                this.readCards("Chance"); //Reading Cards
                dice = new Dice(); //Create a dice
                spaces = new ArrayList<Space>(); //Initialize spaces
 
                players = new ArrayList<Player>();
        for(int i = 0; i < 4; i++){ //Initializing Players
                players.add(new Player(i));
        }
        
 
                int j = 0; //Needed for the brands
                for(int i = 0; i<=35; i++) {
                        if(i == 0) {//Go
                                go = new Go(); //Initializing Go
                                spaces.add(go);
                        } else if(i == 1 || i == 3 || i == 5 || i == 7 ||
                                        i == 8 || i == 10 || i == 11 || i == 13 ||
                                        i ==14 || i == 16 || i == 17 || i == 19 ||
                                        i == 20 || i == 22 || i == 23 || i == 25 ||
                                        i == 26 || i == 28 || i == 29 || i == 31 ||
                                        i == 33 || i == 35) {//Brand
                                ArrayList<Brand> brands = null;
                                if(i == 1) {
                                        brands= brand.getBrands(); //???
                                }
                                spaces.add(brands.get(j));
                                j++;
                        } else if(i == 12 || i == 30) {//Utility
                                if(i == 12)
                                        spaces.add(new Utility("ElectricUtility"));
                                else
                                        spaces.add(new Utility("WaterWorksUtility"));                  
                        } else if(i == 2 || i == 34) {//TowerTax
                                if(i == RIVAL_TOWER_TAX)
                                        spaces.add(new TowerTax("RivalTowerTax"));
                                else
                                        spaces.add(new TowerTax("TowerTax"));
                        } else if(i == 4 || i == 25) {//Empire
                                // ? spaces.add(new Card("Empire"));
                        } else if(i == 6 || i == 15 || i == 21 || i == 32) {//Chance
                                // ? spaces.add(new Card("Chance"));
                        } else if(i == JUST_VISITING) {//JustVisiting
                                spaces.add(new JustVisiting("JustVisiting"));
                        } else if(i == FREE_PARKING) {//FreeParking
                                spaces.add(new FreeParking("FreeParking"));
                        } else if(i == GO_TO_JAIL) {//GoToJail
                                spaces.add(new GoToJail());
                        }
                }
        }
        
        private void readCards(String name){
            ArrayList<String> lines = new ArrayList<String>();
            ArrayList<Card> cards = new ArrayList<Card>();
            
            try{
                            FileReader fileIn = new FileReader(name);
                            BufferedReader in = new BufferedReader(fileIn);
                            String currentLine;
                           
                            while((currentLine = in.readLine()) != null){
                                    String line1 = currentLine;
                                    String line2 = in.readLine();
                                    String line3 = in.readLine();
                                    lines.add(line1 + System.lineSeparator() + line2
                                                    + System.lineSeparator() +line3 + System.lineSeparator() );
                            }
                           
                            in.close();
                    }
                    catch(FileNotFoundException e) {
                            e.printStackTrace();
                    }
                    catch(IOException e) {
                            e.printStackTrace();
                    }
            
            int typeOfCard, code;
            String content, title, theContent;
            for(int i = 0; i<=lines.size(); i++){
            	theContent = lines.get(i);
            	typeOfCard = Integer.parseInt(theContent.substring(0, theContent.indexOf(",")));
                theContent = theContent.substring(theContent.indexOf(","), theContent.length());
                code = Integer.parseInt(theContent.substring(0, theContent.indexOf("/n")));
                theContent = theContent.substring(theContent.indexOf("/n"), theContent.length());
                title = theContent.substring(0, theContent.indexOf("/n"));
                theContent = theContent.substring(theContent.indexOf("/n"), theContent.length());
                content = theContent;

                if(name.equals("Empire")) 
                	empires.add(new Empire(name, typeOfCard, code, title, content));
                else
                	chances.add(new Chance(name, typeOfCard, code, title, content));
            }
        }
       
       
       
//        public void playerActOnPosition(Player player) {
//                int position = player.getPosition();
//                int previousPosition = player.getPreviousPosition();
//               
//               
//                if (spaces.get(0) instanceof Brand){
//                        boolean yesorno;
//                       
//                }
//                if(position == 0) {//Go
//                        go.passGo(player);
//                } else if(position == 1 || position == 3 || position == 5 || position == 7 ||
//                                position == 8 || position == 10 || position == 11 || position == 13 ||
//                                position ==14 || position == 16 || position == 17 || position == 19 ||
//                                position == 20 || position == 22 || position == 23 || position == 25 ||
//                                position == 26 || position == 28 || position == 29 || position == 31 ||
//                                position == 33 || position == 35) {//Brand
//                        Brand brand = Brand.returnBrandWithPosition(position);
//                        if(brand.hasOwner()) {
//                                if(player.hasMoney(brand.getOwner().getMoney())) {
//                                        player.decreaseMoney(brand.getOwner().getMoney());
//                                }
//                                else{
//                                        // ???
//                                }
//                        }
//                        else {
//                                // ???
//                        }
//                } else if(position == 12 || position == 30) {//Utility //??????????
//                        if(position == 12 && Utility.hasMoreElectric()){
//                                if(player.hasMoney(150)) {
//                                        int optionPane = JOptionPane.showConfirmDialog(null,
//                                                        "Would you like to buy the electric company?",
//                                                        "Electric Company",
//                                                        JOptionPane.YES_NO_OPTION);
//                                        if(optionPane == JOptionPane.YES_OPTION){
//                                                player.decreaseMoney(150);
//                                                player.getMyScyscraper().addBrutility(new Utility("Utility"));
//                                                Utility.decreaseElectric();
//                                        }
//                                }
//                        }
//                        if(position == 30 && Utility.hasMoreWater()){
//                                if(player.hasMoney(150)) {
//                                        int optionPane = JOptionPane.showConfirmDialog(null,
//                                                        "Would you like to buy the water works?",
//                                                        "Electric Company",
//                                                        JOptionPane.YES_NO_OPTION);
//                                        if(optionPane == JOptionPane.YES_OPTION){
//                                                player.decreaseMoney(150);
//                                                player.getMyScyscraper().addBrutility(new Utility("Utility"));
//                                                Utility.decreaseWater();
//                                        }
//                                }
//                        }
//                       
//                } else if(position == 2 || position == 34) {//TowerTax
//                       
//                } else if(position == 4 || position == 25) {//Empire
//                       
//                } else if(position == 6 || position == 15 || position == 21 || position == 32) {//Chance
//                       
//                } else if(position == 9) {//JustVisiting
//                       
//                } else if(position == 18) {//FreeParking
//                       
//                } else if(position == 27) {//GoToJail
//                       
//                }
//               
//                // If the player passed GO without standing on GO.
//                if( (previousPosition<=35 && previousPosition>= 25) && (position>=1 && position<=12) )
//                        go.passGo(player);
//                player.setPreviousPosition(position);
//               
//               
//               
//               
//               
//        }
       
        public void setActivePlayer(int activePlayerCode){
        activePlayer = players.get(activePlayerCode);
    }
       
        public Player getActivePlayer(){
        return activePlayer;
    }
 
        private void play(){
               
                while(! (winConditions())){
                        if(activePlayer.isInJail()){
                               
                        }
                        else{
                                int roll = dice.rollTheDice();
                               
                                if(dice.isSneaky()){ //If the player rolls a sneaky exchange
                                        if(gameFeedbackListener.onSneakyDiceRolled() == Game.DICE_YES){ //He is asked if he wants to make the exchange
                                               int playerCode = onChooseEnemyPlayer(activePlayer.getCode(), "Choose a player to swap with other than yourself"); //If he agrees, he is asked for the opponent player's code
                                               activePlayer.getSkyscraper().diceRollSneakyExchange(players.get(playerCode).getSkyscraper()); //and the exchange takes place 
                                               
                                               Brutility tempBru = activePlayer.getSkyscraper().getBrutility();
                                               
                                               if (tempBru instanceof Brand){
                                            	   ((Brand) tempBru).setOwner(players.get(playerCode));
                                               }
                                               
                                               tempBru = players.get(playerCode).getSkyscraper().getBrutility();
                                               
                                               if (tempBru instanceof Brand){
                                            	   ((Brand) tempBru).setOwner(activePlayer);
                                               }
                                        }
                                        else{ //Player has refused to use the sneaky exchange
                                        	activePlayer.movePlayer(roll);
                                        	onPlayerMoved();
                                        	actOnPosition();
                                        }
                                        
                               
                                       
                                }
                                else{ //The player didn't roll a sneaky exchange
                                	activePlayer.movePlayer(roll);
                                	onPlayerMoved();
                                	actOnPosition();
                                }
                        }
                       
                       
                }
               
               
        }
       
        private void actOnPosition(){
        	int position = activePlayer.getPosition();
        	Space spacePosition = spaces.get(activePlayer.getPosition());
        	
        	if (spacePosition instanceof Go){
        		Go.passGo(activePlayer);
        		gameFeedbackListener.onPlayerMovedToGO(activePlayer.getMoney());
        	}
        	else if(spacePosition instanceof Brand){
        		Brand brand = ((Brand) spacePosition);
        		
        		boolean hasMoney = true;
        		String skyscraperName = activePlayer.getSkyscraper().getBrutility().getName();
        		
        		if (brand.hasOwner()){
        			Player otherPlayer = brand.getOwner();
        			if (activePlayer == otherPlayer){ //Brand belongs to other player
        				if (activePlayer.canPay(otherPlayer)){ //Player has enough money to pay
            				activePlayer.payPlayer(otherPlayer);
            			}
        				else{ // if player doesn't have enough money
        					hasMoney = false;
        					if (activePlayer.getSkyscraper().isEmpty()){ // Player has no brutilities. He does nothing
        						
        					}
        					else { //player has a brutility in his skyscraper
        						otherPlayer.getSkyscraper().addBrutility(activePlayer.getSkyscraper().popBrutility()); //Transfer topmost Brutility to the other player
        						
        						Brutility tempBru = otherPlayer.getSkyscraper().getBrutility();
                                
                                if (tempBru instanceof Brand){
                             	   ((Brand) tempBru).setOwner(players.get(otherPlayer.getCode()));
                                }
        						
        					}
        				}
        				
        				gameFeedbackListener.onPlayerMovedToBrandOwnedBySomeoneElse(brand.getName(), hasMoney, activePlayer.getMoney(), brand.getCost(), skyscraperName);
        			}
        			else { //Brand has no owner
        			
        				int choice = gameFeedbackListener.onPlayerMovedToBrandNotOwned(brand.getName(), activePlayer.hasMoney(brand.getCost()), activePlayer.getMoney(), brand.getCost());
        				if (brand.canBuy(activePlayer.getMoney())){
        					if (choice == JOptionPane.YES_OPTION) {//want to buy)
        						brand.buyBrand(activePlayer);
        						
        					}
        					else { // Doesn't want to buy
        						//No code needed
        					}
        				}       							      			
        				else { // Can't buy
        					//No code needed
        				}
        			
        			
        			}
        			
        			
        		} 
        		else{// Brand belongs to you
        			gameFeedbackListener.onPlayerMovedToBrandOwnedByHim(brand.getName());
        		}
        		
        			
        			
        			
        			
        	}
        	
        	
        	else if(spacePosition instanceof Utility){
        		
        		Utility utility = ((Utility) spacePosition);
        		
        		int choice = gameFeedbackListener.onPlayerMovedToUtility(utility.getUtilityName(), utility.hasUtilities(), activePlayer.hasMoney(UTILITY_COST), activePlayer.getMoney());
        		
        		if(choice == JOptionPane.YES_OPTION){
            				utility.decreaseUtilities();
            				activePlayer.decreaseMoney(UTILITY_COST);
        		}
            	
        	}
        	else if(spacePosition instanceof Card){
            	
        	}
        	else if(spacePosition instanceof TowerTax){
        		int playerCode;
        		if (position == RIVAL_TOWER_TAX){
        			playerCode = gameFeedbackListener.onChooseEnemyPlayer("You landed on Rival Tower Tax. Remove an enemy's top Brutility");
        		}
        		else {
        			playerCode = activePlayer.getCode();
        		}
        	
            	Brutility tempBru = players.get(playerCode).getSkyscraper().popBrutility();
            	if (tempBru instanceof Brand){
            		((Brand) tempBru).setOwner(null);
            	}
            	else{ //Brutility is a Utility
            		
            		((Utility) spaces.get(position)).increaseUtilities();
            	}
        	}
        	else if(spacePosition instanceof JustVisiting){
        		gameFeedbackListener.onPlayerMovedToJustVisiting();
            	
        	}
        	else if(spacePosition instanceof GoToJail){
        		
        		activePlayer.setPosition(GO_TO_JAIL);
        		gameFeedbackListener.onPlayerMovedToGoToJail();
            	
        	}
        	else if(spacePosition instanceof FreeParking){
        		boolean canUseFreeParking = activePlayer.hasMoney(Game.FREE_PARKING_COST);
        		if (canUseFreeParking){
        			if (true){//want to move anywhere
           			 position = 0; //Get position from user
           			 activePlayer.decreaseMoney(Game.FREE_PARKING_COST);
           			 activePlayer.setPosition(position);
           			 actOnPosition();
        			}	
        			
        		}
        		else {
        			//Prompt that you landed but don't have enough money
        		}
            	
        	}
        	
        }
        
        private int onChooseEnemyPlayer(int activePlayerCode, String message){
        	int playerCode;
            do{
            	playerCode = gameFeedbackListener.onChooseEnemyPlayer(message);
            }while(playerCode == activePlayer.getCode() && (playerCode == 0 ||playerCode == 1 || playerCode == 2 || playerCode == 3 ));
            return playerCode;
        }     
       
        private boolean winConditions(){ 
        		return activePlayer.getSkyscraper().isFull(); // If the player's skyscraper height exceeds over maximum he 
        									
        }
       
        public void setGameFeedbackListener(GameFeedbackListener listener){
                gameFeedbackListener = listener;
        }
       
        GameFeedbackListener gameFeedbackListener;
       
        public void onPlayerMoved(){
                gameFeedbackListener.onPlayerMoved(activePlayer.getCode(), activePlayer.getPosition());
    }
       
       
       
    public interface GameFeedbackListener{
        public void onPlayerMoved(int playerCode, int playerPosition);
       
        public void onPlayerMovedToGO(int money);
        
        public void onPlayerMovedToJustVisiting();
        
        public void onPlayerMovedToGoToJail();
        
        public void onPlayerMovedToBrandOwnedByHim(String name);
        
        public void onPlayerMovedToBrandOwnedBySomeoneElse(String name, boolean hasMoney, int cost, int money, String skyscraperName);
        
        public int onPlayerMovedToBrandNotOwned(String name, boolean hasMoney, int money, int cost);
    
        public int onPlayerMovedToUtility(String utilityName, boolean hasUtilitiesLeft, boolean hasMoney, int money);
        
        public int onChooseEnemyPlayer(String message);
        
       
        public int onSneakyDiceRolled();
       
               
       
       
    }
}