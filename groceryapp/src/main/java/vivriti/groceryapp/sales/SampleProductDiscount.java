package vivriti.groceryapp.sales;

import vivriti.groceryapp.sales.domain.Discount;
import vivriti.groceryapp.sales.domain.DiscountStrategy;
import vivriti.groceryapp.sales.domain.SalesCartItem;

public class SampleProductDiscount implements DiscountStrategy {

	@Override
	public void applyDiscount(SalesCartItem scitem) {
          
		 //put the algorithm here to apply the discount. 
		// for sample I am giving 10% on all products
          
		final String DISC_DESC = "Standard 10% Discount to all products";
		Discount discount = new Discount();
		discount.setAmount(scitem.getSaleAmount() * 0.1);
		discount.setDisc(DISC_DESC);
		scitem.addDiscount(discount);
       
	}

}
