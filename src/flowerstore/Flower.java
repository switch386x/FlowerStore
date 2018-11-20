package flowerstore;
import java.math.BigDecimal;

public class Flower {

	public Flower(String type, String color, String height, BigDecimal price){
		this.setFlowerType(type);
		this.setFlowerColor(color);
		this.setFlowerHeight(height);
		this.setFlowerPrice(price);
	}
	    
		public BigDecimal price;
	    public String color;
	    public String height;
	    public String type;
	    public int amount;
	    
	    //is it a good practice to create a gette with this kind of modification?
	    public BigDecimal getFlowerPrice(Currencies currency) {
	        currency.getCurrencyCode();
	        return price.multiply(currency.getExchangeRate());	        
	    }
	    
	    public void setFlowerPrice(BigDecimal price){
	    	this.price = price;
	    }
	    
	    public String getFlowerColor(){
	    	return color;
	    }
	    
	    public void setFlowerColor(String color){
	    	this.color = color;
	    }
	    public String geFlowerHeight(){
	    	return height;
	    }
	    
	    public void setFlowerHeight(String height){
	    	this.height = height;
	    	
	    }
	    private void setFlowerType(String type) {
	            this.type = type;        
	    }
	        

		
}
