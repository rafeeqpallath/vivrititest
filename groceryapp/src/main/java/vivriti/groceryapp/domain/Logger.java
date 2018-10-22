package vivriti.groceryapp.domain;

import vivriti.groceryapp.sales.domain.SalesCart;

public interface Logger {
	
	public void logSales(SalesCart salesCart);

}
