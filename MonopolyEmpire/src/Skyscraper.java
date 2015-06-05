import java.util.ArrayList;
import java.util.LinkedList;
 
 
public class Skyscraper {
       
        private int height = 0;
        private LinkedList<Brutility> ownership;
        
        private static final int MAX_HEIGHT = 800;
       
        public Skyscraper() {
        	ownership = new LinkedList<Brutility>();
           
        }
       
        private boolean isFull() {            
                return height == MAX_HEIGHT;
        }
        
        private boolean isEmpty(){
        	return height == 0;
        }
       
        public void addBrutility(Brutility brutility) {
                if(isFull())
                        System.out.println("Sorry, but your Skyscraper is full.");// ???
                else {
                       ownership.add(brutility);
                }
        }
         
        public int getHeight() {
                return height;
        }
       
        
        private Brutility popBrutility() {
              
                if(isEmpty()){
                	System.out.println("The skyscraper is empty.");
                	return null;
                }
                
                else {
                	return ownership.pop();
                }
        }
        
        public void diceRollSneakyExchange(Skyscraper otherSkyscraper){
        	Brutility tempBrutility = popBrutility();
        	addBrutility(otherSkyscraper.popBrutility());
        	otherSkyscraper.addBrutility(tempBrutility);
        	
        }
        
        
        
        
}