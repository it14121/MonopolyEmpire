import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Brand extends Brutility {
	
	private ArrayList<Brand> brands;
	private String color;
	private int owner = 0;
	
	public Brand() {
		brands = new ArrayList<Brand>();
		brands = readBrands();
	}
	
	public Brand createABrand(String aColor, String aName, int  aPosition, int aBuyCost) {
		color = aColor;
		name = aName;
		position = aPosition;
		buyCost = aBuyCost;
		return this;
	}
	
	public ArrayList<Brand> readBrands() {
		ArrayList<Brand> lines = new ArrayList<Brand>();
		try{
			FileReader fileIn = new FileReader(name);
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
	public Brand returnBrand() {
		return this;
	}
	
	public boolean hawOwner() {
		if(owner == 0)
			return false;
		else
			return true;
	}
	
	public void setOwner(Player p) {
		if((p.getMoney()>= this.buyCost) )/// ???
			owner = p.getCode();
		else
			System.out.println("Sorry, but player " + p.getCode() + " cannot buy this brand!");
	}
	
	public int getOwner() {
		return owner;
	}
	
	public String getColor() {
		return color.toString();
	}
	
	
	
	
}
