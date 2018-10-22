package vivriti.groceryapp;

import vivriti.groceryapp.domain.BillerStrategy;
import vivriti.groceryapp.sales.domain.SalesCart;
import vivriti.groceryapp.sales.domain.SalesCartItem;

// This is a class Simple biller strategy that would print SalesCart item to Sys.out
public class SimpleBiller implements BillerStrategy {

	@Override
	public void generatePrintBill(SalesCart saleCart) {
		
		System.out.println();
		System.out.println();
		System.out.println("***********Purchase Bill******");
		for(SalesCartItem sc: saleCart.getScItems()) {
		
	      System.out.println(sc.getItem()+ ", Price :"+sc.getItem().getPrice()+
	    		  ", Quantity :"+sc.getQuantity() +
	    		  ", Total Amount :"+ sc.getSaleAmount() +
	    		  ", Total Discount :" + sc.getTotalDiscount() +
	    		  ", Payable Amount :" + sc.getNetAmount());
		}
		
		System.out.println("**********Total Payable Amount: " + saleCart.getTotalAmount());
		System.out.println("*********Thanks You************");
		System.out.println();
		System.out.println();
 
	}

}
