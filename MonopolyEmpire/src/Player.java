import java.util.ArrayList;
 
 
public class Player {
       
        private int code;
        private int money;     
        private Skyscraper skyscraper;
        private int position, previousPosition;
        private ArrayList<Card> cardsInHand;
        private boolean inJail;
        private final static int STARTING_MONEY = 100;
        private final static int STARTING_POSITION = 0;
       
        public Player(int aCode) {
                code = aCode;
                money = STARTING_MONEY;
                skyscraper = new Skyscraper();
                position = STARTING_POSITION;
                cardsInHand = new ArrayList<Card>();
                inJail = false;
        }
       
        public boolean isInJail() {
                return inJail;
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
                if(m > money)
                        return false;
                else
                        return true;
        }
       
        public void addPosition(int roll) {

                position = position + roll;
                if (position > 35) position = position % 36;
                
        }
 
        public int getCode() {
                return code;
        }
       
        public int getPreviousPosition() {
                return previousPosition;
        }
       
        public int getPosition() {
                return position;
        }
 
        public int getMoney() {
                return money;
        }
   
 
        public void movePlayer(int roll){
        	previousPosition = position;
        	addPosition(roll); 
        }
        
        public Skyscraper getSkyscraper() {
                return skyscraper;
        }
       
        
}