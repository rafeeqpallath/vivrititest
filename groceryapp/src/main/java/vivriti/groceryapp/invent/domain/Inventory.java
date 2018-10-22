package vivriti.groceryapp.invent.domain;

import java.util.List;

public interface Inventory {
	

	public void addItem(Item item, long num);
	public void addItems(List<InventoryItem> items);
	public boolean isItemAvailable(Item item, long quantity);
	public long getAvailableQuantity(Item item);
	public void updateInventoryForSale(Item item, long quantiy);
	public void updateInventoryForReversal(Item item, long quantity);
    public List<InventoryItem> getInventoryItems();

}
