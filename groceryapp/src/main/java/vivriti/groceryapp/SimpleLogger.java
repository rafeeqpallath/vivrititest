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

}
