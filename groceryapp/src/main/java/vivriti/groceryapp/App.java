package vivriti.groceryapp;

import java.util.ArrayList;
import java.util.List;

import vivriti.groceryapp.domain.BillerStrategy;
import vivriti.groceryapp.domain.Logger;
import vivriti.groceryapp.domain.PaymentStrategy;
import vivriti.groceryapp.domain.Register;
import vivriti.groceryapp.invent.InventoryManager;
import vivriti.groceryapp.invent.domain.Inventory;
import vivriti.groceryapp.invent.domain.InventoryItem;
import vivriti.groceryapp.invent.domain.Item;

/**
 * This is the DemoApp 
 *
 */
public class App 
{
	static PaymentStrategy cashPayment = new CashPayment();
	static BillerStrategy simpleBiller = new SimpleBiller();
    static Logger simpleLogger = new SimpleLogger();
	public static void main(String[] args )
    {

      // Initialise the Application Context, this will load the discount strategies to memory
    	AppContextFactory.getAppContext();
      
    	initialiseInventory();
   
 	   System.out.println("*****Printing the Initial Inventory Position***");
    	printInventory();
	   System.out.println("*******Printing Completed *********");
 	   
       // Now that We initialised the inventory and put some data into it, also printed and saw it
    // lets do some sales..
 	
    	doSomeSales();
    	
  	   System.out.println("*****Printing the Post sales Inventory Position***");
     	printInventory();
 	   System.out.println("*******Printing Completed *********");
    	
    	return;  
        
    }
    
   static void printInventory() {
	
	   
	   for (InventoryItem invIt : InventoryManager.getInstance().getInventoryItems()) {
		   

		   System.out.println(invIt.toString());

	   }
   }
   static void initialiseInventory( ) {
	   // Initialise the Inventory and store some Items in the inventory
   	
	      Item item1 = new Item("abcde", "The First Item", "Sample First Item added",10.00f);
	      Item item2 = new Item("bcdef", "The Second Item", "Sample Second Item added",15.00f);
	      Item item3 = new Item("cdefg", "The Third Item", "Sample Third Item added",18.00f);
	      Item item4 = new Item("defgh", "The Fourth Item", "Sample Fourth Item added",10.00f);
	      Item item5 = new Item("efghi", "The Fifth Item", "Sample Fifth Item added",15.00f);
	      Item item6 = new Item("fghij", "The Sixth Item", "Sample Sixth Item added",18.00f);
	      Item item7 = new Item("ghijk", "The Seventh Item", "Sample Seventh Item added",10.00f);
	      Item item8 = new Item("hijkl", "The Eightth Item", "Sample Eighth Item added",15.00f);
	      Item item9 = new Item("ijklm", "The Nineth Item", "Sample Nineth Item added",18.00f);
	      Item item10 = new Item("jklmn", "The Tenth Item", "Sample Tenth Item added",10.00f);
	      Item item11 = new Item("klmno", "The Eleventh Item", "Sample Eleventh Item added",15.00f);
	      Item item12 = new Item("lmnop", "The Twelveth Item", "Sample Twevelvth Item added",18.00f);
	      
	      
	      Inventory inv = InventoryManager.getInstance();
	      inv.addItem(item1, 10);
	      inv.addItem(item2, 15);
	      inv.addItem(item3, 20);
	      inv.addItem(item4, 10);
	      inv.addItem(item5, 15);
	      inv.addItem(item6, 20);
	      inv.addItem(item7, 10);
	      inv.addItem(item8, 15);
	      inv.addItem(item9, 20);
	      inv.addItem(item10, 10);
	      inv.addItem(item11, 15);
	      inv.addItem(item12, 20);
   }
   
   static void doSomeSales() {
	   
	   //Create the Register object
	   
	   Register register = new RegisterService();
	   // Initialise the register object with an fresh SalesCart object
	   register.startSale();
	   
	   // billing my first item. 

	   enterSalesForItemCode(register,"bcdef", 3);
	   
	   // the second item
	   enterSalesForItemCode(register,"fghij", 5);
	   
	   // the third item 
	   
	   enterSalesForItemCode(register,"ijklm", 1);
	   
	   // Ok thats it.
	   // The customer is going to checkout 
	   // He pay by simple Cash, 
	   PaymentStrategy payment = new CashPayment();
	   // The bill should printed to std out.

	   
	   // Ok here goes the checking out.
	   
	   register.checkOutCart(cashPayment, simpleBiller);
	   
	   // Now the Sale is done, and I am closing the sale.
	   // I need to suggest where to save the sales as log for future analysis

	   register.closeSale(simpleLogger);
   }
   
   static void enterSalesForItemCode(Register register,String code, int num) {
	   //first searchItem in the inventory

	   Item it = register.searchItemInInventory(code);
	   // check if item exists if yes, add the item into cart with required quantity
	   if (it != null) {
		   
		   register.addItemtoCart(it, num);
		   System.out.println("Item Added to cart successfully: "+code);
		   
	   } else {
		   System.out.println("Item not found in Inventory: "+ code); 
	   }
	   
   }
    
}
