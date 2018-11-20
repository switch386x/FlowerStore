package flowerstore;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/** TO DO: exception handling
           currencies
*/
public class FlowerStore {

		public BigDecimal preBundle;
		
		
		//flower species declaration
		Flower rose = new Flower("rose", "blue", "10", new BigDecimal(3));
		Flower sunflower = new Flower("sunflower", "green", "20", new BigDecimal(1));
		Flower tulip = new Flower("tulip", "yellow", "30", new BigDecimal(2));
		
		//constraints for the amount of flower holding limits of the structure
		private final int MAX_AMOUNT = 100;
		private final int MIN_AMOUNT = 20;
		
		//structure for containing flowers
		public Map<Flower, Integer> flowerMap = new HashMap<Flower,Integer>();
	
		public FlowerStore(){	    
		    flowerMap.put(rose,1);
		    flowerMap.put(sunflower, 2);    
		    flowerMap.put(tulip, 3);
		}
		
		//method for creating flower bundle returning an array of flowers and cost.
	    public Flower[] createBundle(int roseCount, int sunflowerCount, int tulipCount, Currencies currency){
	        int count = roseCount + sunflowerCount + tulipCount;
	        Flower[] arrayFlowers = new Flower[count];
	        for (int i = 0; i < count; i++) {
	            if (i < roseCount) arrayFlowers[i] = rose;
	            else if (i >= roseCount & i < roseCount + sunflowerCount)
	                arrayFlowers[i] = sunflower;
	            else arrayFlowers[i] = tulip;
	        } 
	        BigDecimal roseCost = rose.getFlowerPrice(currency).multiply(new BigDecimal(roseCount));
	        BigDecimal sunfCost = sunflower.getFlowerPrice(currency).multiply(new BigDecimal(sunflowerCount));
	        BigDecimal tulpCost = tulip.getFlowerPrice(currency).multiply(new BigDecimal(tulipCount));
	        if (preBundle == null) preBundle = new BigDecimal(0);
	        preBundle = preBundle.add(roseCost.add(sunfCost.add(tulpCost))); //checking for the existing bundle, if not the preBundle variable gets starting value
	        return arrayFlowers;
	    }
	    
	    //method for ordering flowers if the amount in the structure is not sufficient and falls under constraints
        public boolean orderFlowers(int roseCount, int sunflowerCount, int tulipCount){
	    if(sunflowerCount <= 0 || flowerMap.get(sunflower) > MIN_AMOUNT || sunflowerCount + flowerMap.get(sunflower) > MAX_AMOUNT) return false;    	        
	    if(roseCount <= 0 || flowerMap.get(rose) > MIN_AMOUNT || roseCount + flowerMap.get(rose) > MAX_AMOUNT) return false;        
        if(tulipCount <= 0 || flowerMap.get(tulip) > MIN_AMOUNT || tulipCount + flowerMap.get(tulip) > MAX_AMOUNT) return false;    
        
        flowerMap.put(tulip, tulipCount + flowerMap.get(tulip));
        flowerMap.put(sunflower, sunflowerCount + flowerMap.get(sunflower));
        flowerMap.put(rose, roseCount + flowerMap.get(rose));
        return true;
        }
       //method for displaying current amount of each flower in the inventory structure 
       public void displayInventory(){ 
            for (Entry<Flower, Integer> i: flowerMap.entrySet()){
                System.out.println(i.getKey().type);
                System.out.println(i.getValue());
            }
       }
       //MAIN
       public static void main(String[] args) {
	            FlowerStore flowerStore = new FlowerStore();            
	            Flower[] buqet = flowerStore.createBundle(10,2,5,Currencies.GBP); //here change currency mode
	            flowerStore.displayInventory();
	            flowerStore.orderFlowers(1, 2, 3);
	            flowerStore.displayInventory();
	            System.out.println();
	            System.out.println("selected bundle cost: " + flowerStore.preBundle + " " + Currencies.GBP);	// and here aswell    
	}
}
