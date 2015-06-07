import java.util.ArrayList;
 
 
public class Player {
       
        private int code;
        private int money;     
        private Skyscraper skyscraper;
        //private int position, previousPosition;
        private int position;
        private ArrayList<Card> cardsInHand;
        private int inJail; //inJail keeps if you are not in jail (0) or if you are how many rounds you've been in (1-3)
        private final static int STARTING_MONEY = 100;
        private final static int STARTING_POSITION = 0;
       
        public Player(int aCode) {
                code = aCode;
                money = STARTING_MONEY;
                skyscraper = new Skyscraper();
                position = STARTING_POSITION;
                cardsInHand = new ArrayList<Card>();
                inJail = 0; // -0 is set for false
        }
        
        public void increaseInJail(){
        	inJail ++;
        }
        
        public void setFreeFromJail(){
        	if (inJail == 3) inJail = 0;
        }
        
        public boolean isInJail() {
                return (inJail > 0);
        }
 
        public void addCardInHand(Card card) {
                cardsInHand.add(card);
        }
       
        public void addMoney(int m) {
                money += m;
        }
       
        public void decreaseMoney(int m) {
                money -= m;
        }
       
        public boolean hasMoney(int m) {
                return (money - m >= 0);
        }
       
        public void addPosition(int roll) {

                position = position + roll;
                if (position > 35) position = position % 36;
                
        }
        
        public boolean canPay(Player player){
        	return (getMoney() >= player.getSkyscraper().getHeight());
        }
        
        public void payPlayer(Player player){
        	int money = player.getSkyscraper().getHeight();
        	decreaseMoney(money);
        	player.addMoney(money);
        }
 
        public int getCode() {
                return code;
        }
       
//        public int getPreviousPosition() {
//                return previousPosition;
//        }
       
        public int getPosition() {
                return position;
        }
        
        public void setPosition(int aPosition){
        	//setPreviousPosition();
        	position = aPosition;
        }
        
//        private void setPreviousPosition(){
//        	previousPosition = position;
//        }
 
        public int getMoney() {
                return money;
        }
   
 
        public void movePlayer(int roll){
        	//setPreviousPosition();
        	addPosition(roll); 
        }
        
        public Skyscraper getSkyscraper() {
                return skyscraper;
        }
       
        
}