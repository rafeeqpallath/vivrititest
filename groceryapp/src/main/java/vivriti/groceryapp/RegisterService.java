package vivriti.groceryapp;

import vivriti.groceryapp.domain.BillerStrategy;
import vivriti.groceryapp.domain.Logger;
import vivriti.groceryapp.domain.PaymentStrategy;
import vivriti.groceryapp.domain.Register;
import vivriti.groceryapp.invent.InventoryManager;
import vivriti.groceryapp.invent.domain.Inventory;
import vivriti.groceryapp.invent.domain.InventoryItem;
import vivriti.groceryapp.invent.domain.Item;
import vivriti.groceryapp.sales.SalesCartManager;
import vivriti.groceryapp.sales.domain.SalesCart;
import vivriti.groceryapp.sales.domain.SalesCartItem;

public class RegisterService implements Register {

	private SalesCart salesCart;
	@Override
	public void startSale() {

        salesCart = new SalesCartManager();

	}

	@Override
	public Item searchItemInInventory(String itemcode) {

		Inventory inv = InventoryManager.getInstance();
		InventoryItem inventoryItem = (inv.getInventoryItems().stream().filter(p->p.getItem().equalWithCode(itemcode)).findFirst().orElse(null));
		if (inventoryItem != null) {
			return inventoryItem.getItem();
		} else return null;
		
	}

	@Override
	public void addItemtoCart(Item it, int quantity) {
		
		if (InventoryManager.getInstance().isItemAvailable(it, quantity)) {
			salesCart.addItem(it, quantity);			
			
		} else {
			//throw some application exception here, to indicate item not available in cart
			System.out.println(it.toString() + " not available");
		}
			

		

	}

	@Override
	public void removeItemFromCart(Item it) {

         salesCart.removeItem(it);

	}

	@Override
	public void checkOutCart(PaymentStrategy payment, BillerStrategy biller) {

           UpdateInventory();
           biller.generatePrintBill(salesCart);;
           payment.makePayment(salesCart.getTotalAmount());      

	}
	
	private void UpdateInventory() {
		
		Inventory inv = InventoryManager.getInstance();
		for (SalesCartItem sc : salesCart.getScItems() ) {
			
			inv.updateInventoryForSale(sc.getItem(), sc.getQuantity());
		}
		
		
	}

	@Override
	public void closeSale(Logger logger) {
	// The client can pass appropriate logger Implementation while closing the sale.
		logger.logSales(salesCart);
       salesCart = null;

	}

}
