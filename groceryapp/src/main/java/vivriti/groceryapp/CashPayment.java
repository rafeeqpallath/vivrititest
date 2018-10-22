package vivriti.groceryapp;

import java.text.DecimalFormat;

import vivriti.groceryapp.domain.PaymentStrategy;

public class CashPayment implements PaymentStrategy {

	@Override
	public void makePayment(double amount) {
		DecimalFormat df2 = new DecimalFormat(".##");
		System.out.println("Cash Payment Made for Rs:" + df2.format(amount));

	}

}
