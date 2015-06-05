import java.util.ArrayList;
 
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
 
//import Card.ActListener;
 
public class Game {
       
        private ArrayList<Player> players;
        private ArrayList<Space> spaces;
        private Player activePlayer;
        private int activePlayerCode = 0; //keeps Player's code of the activePlayer for easier access, Player 0 is always first
        private Go go;
        private Brand brand;
        private Empire empire;
        private Chance chance;
        private Dice dice;
       
        public static final int DICE_YES = -1;
        public static final int DICE_NO = -2;
        
        public static final int IS_SNEAKY = -1;
        public static final int IS_SNEAKY_YES = -2;
       
        public Game() {
               
                //brand = new Brand(null); //Reading Brands
                empire = new Empire(null); //Reading Cards
                chance = new Chance(null);
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
                                if(i == 2)
                                        spaces.add(new TowerTax("RivalTowerTax"));
                                else
                                        spaces.add(new TowerTax("TowerTax"));
                        } else if(i == 4 || i == 25) {//Empire
                                spaces.add(new Card("Empire"));
                        } else if(i == 6 || i == 15 || i == 21 || i == 32) {//Chance
                                spaces.add(new Card("Chance"));
                        } else if(i == 9) {//JustVisiting
                                spaces.add(new JustVisiting("JustVisiting"));
                        } else if(i == 18) {//FreeParking
                                spaces.add(new FreeParking("FreeParking"));
                        } else if(i == 27) {//GoToJail
                                spaces.add(new GoToJail("GoToJail"));
                        }
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
               
                while(winConditions()){
                        if(activePlayer.isInJail()){
                               
                        }
                        else{
                                int roll = dice.rollTheDice();
                               
                                if(dice.isSneaky()){ //If the player rolls a sneaky exchange
                                        if(gameFeedbackListener.onDiceRolled(IS_SNEAKY) == Game.DICE_YES){ //He is asked if he wants to make the exchange
                                                int playerCode = diceRolledSneakyIsYES(activePlayer.getCode()); //If he agrees, he is asked for the opponent player's code
                                               activePlayer.getSkyscraper().diceRollSneakyExchange(players.get(playerCode).getSkyscraper()); //and the exchange takes place
                                               
                                        }
                                        else{ //Player has refused to use the sneaky exchange
                                        	activePlayer.movePlayer(roll);
                                        	onPlayerMoved();
                                        }
                               
                                       
                                }
                        }
                       
                       
                }
               
               
        }
       
        private int diceRolledSneakyIsYES(int activePlayerCode){
                int playerCode;
                do{
                	playerCode = gameFeedbackListener.onDiceRolled(Game.IS_SNEAKY_YES);
                }while(playerCode == activePlayer.getCode() && (playerCode == 0 ||playerCode == 1 || playerCode == 2 || playerCode == 3 ));
                return playerCode;
        }
       
        private boolean winConditions(){ //Need to implement Win Conditions
                return true;
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
    
       
        public void onMovedToBrand();
       
        public int onDiceRolled(int code);
       
               
       
       
    }
}