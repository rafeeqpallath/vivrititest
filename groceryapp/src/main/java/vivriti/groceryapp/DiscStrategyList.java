package vivriti.groceryapp;

import java.util.ArrayList;
import java.util.List;

import vivriti.groceryapp.sales.SampleProductDiscount;
import vivriti.groceryapp.sales.domain.DiscountStrategy;

/**
 * 
 * @author This will be a singleton class that will take care of holding the List of discount strategies available in the Application
 *
 */
public class DiscStrategyList {

	private static DiscStrategyList instance = null;
	
	private List<DiscountStrategy> discStrats;
	
	private DiscStrategyList() {
		
		discStrats = new ArrayList<DiscountStrategy>();
	}
	
	public static DiscStrategyList getInstance() {
		
		if (instance == null) {
			buildDiscStrategies();
		}
		
		return instance;
	}

	// synchronised method to provide threadsafety
	private static synchronized void buildDiscStrategies() {
		
	   if (instance == null)  { //double lock checking to provide threadsafety	
	     // if the it is a bit too complicated logic to be inside a singleton, call a seperate builder  to the build the object
         // Creating all the required strategies for demo.
		   
		  
		  instance = new DiscStrategyList();
		  DiscountStrategy strategy1 = new SampleProductDiscount();
		  instance.discStrats.add(strategy1);
		  
	   } 
	}
	public List<DiscountStrategy> getStrategies() {
		
		//** cloning the list object to make the discountStrategies immutable
		
		return (new ArrayList<DiscountStrategy>(this.discStrats));
	}
	
}
