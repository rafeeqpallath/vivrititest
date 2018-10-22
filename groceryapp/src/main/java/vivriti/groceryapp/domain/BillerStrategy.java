package vivriti.groceryapp.domain;

import vivriti.groceryapp.sales.domain.SalesCart;

public interface BillerStrategy {
	
	public void generatePrintBill(SalesCart saleCart);

}
