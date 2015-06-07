import java.util.LinkedList;
import java.util.NoSuchElementException;
 
 
public class Skyscraper {
       
        private int height = 0;
        private LinkedList<Brutility> ownership;
        
        private static final int MAX_HEIGHT = 800;
       
        public Skyscraper() {
        	ownership = new LinkedList<Brutility>();
           
        }
       
        public boolean isFull() {            
                return height > MAX_HEIGHT;
        }
        
        public boolean isEmpty(){
        	return height == 0;
        }
       
        public void addBrutility(Brutility brutility) {
                
                       ownership.add(brutility);
                
        }
         
        public int getHeight() {
                return height;
        }
       
        public Brutility getBrutility(){
        	return ownership.peek();
        }
        public Brutility popBrutility() {
                   try{         
                	return ownership.pop();      
                   }
                   catch (NoSuchElementException popBrutility){
                	   System.out.println("There is no Brutility to ");
                   }
                   return null;
                
        }
        
        public void diceRollSneakyExchange(Skyscraper otherSkyscraper){
        	
        	Brutility tempBrutility = popBrutility();
        	
        	
        	addBrutility(otherSkyscraper.popBrutility());
        	otherSkyscraper.addBrutility(tempBrutility);
        	
        	
        }
        
        
      
        
}