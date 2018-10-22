package vivriti.groceryapp.sales;

import java.util.LinkedList;
import java.util.List;

import vivriti.groceryapp.AppContext;
import vivriti.groceryapp.AppContextFactory;
import vivriti.groceryapp.invent.domain.Item;
import vivriti.groceryapp.sales.domain.DiscountStrategy;
import vivriti.groceryapp.sales.domain.SalesCart;
import vivriti.groceryapp.sales.domain.SalesCartItem;

/**
 * 
 * @author Rafeeq
 *
 *This is the adapter class for providing a simplified interface for managing Items in the sales cart.
 */
public class SalesCartManager implements SalesCart {

	// Using LinkedList for list implementation, as the adding or removing items is primary requirement
	private List<SalesCartItem> scItems = new LinkedList<SalesCartItem>();
	private double totalCartAmount = 0;
	
	@Override
	public List<SalesCartItem> addItem(Item item, int quantity) {
		SalesCartItem newItemtoAdd = new SalesCartItem(item);
		newItemtoAdd.setQuantity(quantity);
		applyItemDiscount(newItemtoAdd);
		newItemtoAdd.setNetAmount((newItemtoAdd.getSaleAmount() - newItemtoAdd.getTotalDiscount()));
		scItems.add(newItemtoAdd);
		this.totalCartAmount += newItemtoAdd.getNetAmount();
		return scItems;
	}
	
	private void applyItemDiscount(SalesCartItem newItemtoAdd) {
		AppContext ctx = AppContextFactory.getAppContext();
		List<DiscountStrategy> discStrats = ctx.getDiscountStrats();
		
		for (DiscountStrategy discStrategy : discStrats ) {
			
			discStrategy.applyDiscount(newItemtoAdd);
		}
		
	}

	@Override
	public List<SalesCartItem> removeItem(Item it) {
         
		SalesCartItem itemToRemove = scItems.stream().filter(p->p.getItem().equalIgnoreCase(it)).findFirst().orElse(null);
		if (itemToRemove !=null) {
			scItems.removeIf(p-> p.getItem().equalIgnoreCase(it));
			this.totalCartAmount -= itemToRemove.getNetAmount();
		}
		return scItems;
		
		
	}
	

	@Override
	public double getTotalAmount() {
		// TODO Auto-generated method stub
		return this.totalCartAmount;
	}

	@Override
	public List<SalesCartItem> getScItems() {
		
		return scItems;
	}	

}
