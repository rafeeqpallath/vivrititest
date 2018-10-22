package vivriti.groceryapp.invent;

import java.util.ArrayList;
import java.util.List;


import vivriti.groceryapp.invent.domain.Inventory;
import vivriti.groceryapp.invent.domain.InventoryItem;
import vivriti.groceryapp.invent.domain.Item;

/**
 * 
 * @author Rafeeq
 *
 * This class acts as an inventory manager. This is an adapter which provides a simplified interface for managing the inventory.
 * This would provide the required abstraction for the client programs that would manage the grocery transactions(business logic)
 *  This is also a singleton as there will be only a single inventory instance per application.
 */

public class InventoryManager implements Inventory {

	private static Inventory instance = null;
	private List<InventoryItem> items;
	
	// private constructor for singleton
	private InventoryManager() {
		//choosing ArrayList implementation for List as random access and sequential write is the primary usage 
		 this.items = new ArrayList<InventoryItem>();
	}
	
	public static Inventory getInstance() {
		
		if (instance == null) {
			createInventoryInstance();
		}
		
		return instance;
	}
	
	// this is  a synchronized block of code to provide thread safety while creating the singleton instance.
	private static synchronized  void createInventoryInstance() {
		 
		// double lock on instance creation to provide thread safety.
		if (instance == null) {
			
			instance = new InventoryManager();
		} 
			
	}
	
	
	
	public void addItem(Item item, long num) {

		  InventoryItem invItem = new InventoryItem(item,num);
          this.items.add(invItem);
	}
	

	public void addItems(List<InventoryItem> items) {
		this.items.addAll(items);
		
	}

	public boolean isItemAvailable(Item item, long quantity) {
		
		InventoryItem invItem = this.items.stream().filter(p-> p.getItem().equalIgnoreCase(item)).findFirst().orElse(null);
		if (invItem == null) {
			return false;
		}else {
			return (invItem.getQuantity()>0?true:false);
		}
		
	}

	public long getAvailableQuantity(Item item) {

		InventoryItem invItem = this.items.stream().filter(p-> p.getItem().equalIgnoreCase(item)).findFirst().orElse(null);
       
		if (invItem == null) {
			return 0;
		} else
			return (invItem.getQuantity() > 0 ? invItem.getQuantity():0);		
	}

	public void updateInventoryForSale(Item item, long quantity) {
		InventoryItem invItem = this.items.stream().filter(p-> p.getItem().equalIgnoreCase(item)).findFirst().orElse(null);
		if (invItem != null) {
			invItem.reduceQuantity(quantity);
		}
		
	}
	public void updateInventoryForReversal(Item item, long quantity) {
		InventoryItem invItem = this.items.stream().filter(p-> p.getItem().equalIgnoreCase(item)).findFirst().orElse(null);
		if (invItem != null) {
			invItem.addQuantity(quantity);
		}
	}

	public List<InventoryItem> getInventoryItems() {

		return items;
	}

}
