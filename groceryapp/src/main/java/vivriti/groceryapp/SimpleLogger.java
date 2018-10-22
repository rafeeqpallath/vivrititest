package vivriti.groceryapp;

import java.util.ArrayList;
import java.util.List;

import vivriti.groceryapp.domain.Logger;
import vivriti.groceryapp.sales.domain.SalesCart;
import vivriti.groceryapp.sales.domain.SalesCartItem;
// Strategy Implementation for a simple logging in the memory space
public class SimpleLogger implements Logger {

	private static List<List<SalesCartItem>> logOfSales = new ArrayList<List<SalesCartItem>>();
	@Override
	public void logSales(SalesCart salesCart) {
		logOfSales.add(salesCart.getScItems());

	}
	@Override
	public void printSales() {
		
		System.out.println("********Printing today's Sale********");
		int count=0;
		for (List<SalesCartItem> sale: logOfSales) {
			count++;
			System.out.println();
			System.out.println("********Printing Sale No: "+count);
			
			for (SalesCartItem scItem : sale) {
				
				System.out.println(scItem.toString());
				
			}
		}
		System.out.println("********That's all the sales We have had today*******");
		
	}
	

}
