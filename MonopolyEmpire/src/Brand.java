import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
public class Brand extends Brutility {
       
        private static ArrayList<Brand> brands;
        private String brandName;
        private String color;
        private Player owner;
        private int cost;
       
        public Brand(String aName) {
                super(aName);
                if(isTheFirst == 0) {
                        isTheFirst = 1;
                        brands = new ArrayList<Brand>();
                        brands = readBrands();
                }
        }
       
        public Brand createABrand(String aColor, String aBrandName, int  aPosition, int aBuyCost) {
                color = aColor;
                name = "Brand";
                brandName = aBrandName;
                position = aPosition;
                buyCost = aBuyCost;
                owner = null;
                return this;
        }
       
        public  ArrayList<Brand> getBrands() {
                return brands;
        }
       
        public ArrayList<Brand> readBrands() {
                ArrayList<Brand> lines = new ArrayList<Brand>();
                try{
                        FileReader fileIn = new FileReader("Brands.txt");
                        BufferedReader in = new BufferedReader(fileIn);
                        String currentLine;
                        int pos;
                        String nam;
                        String col;
                        int cost;
                        String subString;
                        Brand aBrand;
                       
                        while((currentLine = in.readLine()) != null){
                                subString = currentLine.substring(0, currentLine.indexOf(","));
                                pos = Integer.parseInt(subString);
                                currentLine = currentLine.substring(currentLine.indexOf(",") + 1, currentLine.length());
                               
                                subString = currentLine.substring(0, currentLine.indexOf(","));
                                nam = subString;
                                currentLine = currentLine.substring(currentLine.indexOf(",") + 1, currentLine.length());
                               
                                subString = currentLine.substring(0, currentLine.indexOf(","));
                                cost = Integer.parseInt(subString);
                                currentLine = currentLine.substring(currentLine.indexOf(",") + 1, currentLine.length());
                                 
                                col = currentLine;
                               
                                aBrand = this.createABrand(col, nam, pos, cost);
                                lines.add(aBrand);
                        }
                       
                        in.close();
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException e) {
                        e.printStackTrace();
                }      
                return lines;
        }
        public static Brand returnBrandWithPosition(int pos) {
                Brand b;
                for(int i = 0; i<brands.size(); i++) {
                        b = brands.get(i);
                        if(b.getPosition() == pos)
                                return b;
                }
                return null;
        }
       
        public boolean hasOwner() {
//                if(owner == null)
//                        return false;
//                else
//                        return true;
        	
        	return owner != null;
        }
       
       
        
        public void setOwner(Player player){
        	owner = player;
        }
        public void buyBrand(Player player) {              
                        setOwner(player);
                        player.decreaseMoney(cost);              
        }
       
        public int getPosition() {
                return position;
        }
        public Player getOwner() {
                return owner;
        }
       
        public String getColor() {
                return color.toString();
        }
       
     
        public boolean canBuy(int money){
        	return (money - cost >= 0);
        }
        
        
       
}