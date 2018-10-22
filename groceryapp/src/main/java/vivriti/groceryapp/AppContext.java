package vivriti.groceryapp;


import java.util.List;

import vivriti.groceryapp.sales.domain.DiscountStrategy;

/***
 * 
 * @author Rafeeq
 *
 *This class manages holds the context data. The shareable immutable objects in various scopes can be put in here and retrieved later in the app
 * This currently holds the discountStrategies
 */
 public class AppContext { 

     private List<DiscountStrategy> discountStrats;

	public List<DiscountStrategy> getDiscountStrats() {
		return discountStrats;
	}

	public void setDiscountStrats(List<DiscountStrategy> discountStrats) {
		this.discountStrats = discountStrats;
	}
     
  
     
}
