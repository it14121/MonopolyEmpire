
import java.util.LinkedList;

import javax.swing.ImageIcon;

 
 
public class CardSpace extends Space {
       
	    
        protected ImageIcon icon;
        private LinkedList<Card> cards;
        
      
       public CardSpace(String aName){
    	   super(aName);
       }
//        public CardSpace(String aName, LinkedList<Card> aCards){
//                super(aName);
//                cards = aCards;
//                		                
//        }
 
 
//        public void holdCard(Player p){
//        	if(content.contains("Keep this card")) {
//                JDialog.setDefaultLookAndFeelDecorated(true);
//            int response = JOptionPane.showConfirmDialog(null,
//                        "Do you want to continue?",
//                        "Confirm",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.QUESTION_MESSAGE);
//            if (response == JOptionPane.YES_OPTION) {
//                p.addCardInHand(this);
//            }
//        }
        
        public Card getCard(){
        	return cards.peek();        	
        }
        
        public void holdCard(){
        	cards.poll();
        }
        
        public void removeCard(){
        	cards.poll();
        }
        
        public LinkedList<Card> getCards(){
        	return cards;
        }
        
//        public void useCard(){
//        	holdCard();
//        	returnCard();
//        }
        
        
        
    }
   
   
        
        class Card{
        	protected int code;
            protected int typeOfCard;
            protected String title;
            protected String message;
            
            public Card(int aCode, int aTypeOfCard, String aTitle, String aMessage){
            	code = aCode;
            	typeOfCard = aTypeOfCard;
            	title = aTitle;
            	message = aMessage;            			
            }

			public int getCode() {
				return code;
			}

			public int getTypeOfCard() {
				return typeOfCard;
			}

			public String getTitle() {
				return title;
			}

			public String getMessage() {
				return message;
			}
            
            
        }
   
