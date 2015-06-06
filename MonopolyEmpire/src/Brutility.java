import javax.swing.Icon;
 
 
public abstract class Brutility extends Space {
       
        private Icon picture;// ???
        protected int buyCost;
        protected static int isTheFirst = 0;
       
        public Brutility(String aName) {
                super(aName);
        }
 
        public String getName(){
        	return name;
        }
}
