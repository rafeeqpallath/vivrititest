package vivriti.groceryapp.domain;


import vivriti.groceryapp.invent.domain.Item;

public interface Register {
	
	public void startSale(); 
	public Item searchItemInInventory(String itemcode); 
    public void addItemtoCart(Item it, int quantity);		
    public void removeItemFromCart(Item it);
    public void checkOutCart(PaymentStrategy payment,BillerStrategy biller);
    public void closeSale(Logger logger);
    
}
