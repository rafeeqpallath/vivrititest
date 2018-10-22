package vivriti.groceryapp.sales.domain;

import java.util.List;

import vivriti.groceryapp.invent.domain.Item;

public interface SalesCart {
	
	public List<SalesCartItem> addItem(Item it, int quantity);
	public List<SalesCartItem> removeItem(Item it);
	public double getTotalAmount();
	public List<SalesCartItem> getScItems();

}
