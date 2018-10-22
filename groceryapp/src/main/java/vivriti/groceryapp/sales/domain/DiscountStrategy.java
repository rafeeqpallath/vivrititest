package vivriti.groceryapp.sales.domain;

/***
 * 
 * @author Rafeeq
 *
 *This is an interface strategy. The various implementation may use this to apply the various type of discounts available during purchase.
 *
 */

public interface DiscountStrategy {
	
	public void applyDiscount(SalesCartItem scitem);

}
