import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
 
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
 
public abstract class Card extends Space {
       
	    protected String title;
        protected String content;
        protected ImageIcon icon;
        protected int code, typeOfCard;
       
        public Card(String aName, int aTypeOfCard, int aCode, String aTitle, String aContent){
                super(aName);
                typeOfCard = aTypeOfCard;
                code = aCode;
                title = aTitle;
                content = aContent;
        }
 
 
        public void holdCard(Player p){
        	if(content.contains("Keep this card")) {
                JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(null,
                        "Do you want to continue?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                p.addCardInHand(this);
            }
        }
    }
   
   
//    public void act(ActListener actListener){
//        if(actListener.prompt()){
//               
//        }else{
//               
//        }
//       
//        actListener.ask(1);
//    }
//    public interface ActListener{
//        public boolean prompt();
//       
//        public int ask(int code);
//               
//       
//       
//    }
   
}