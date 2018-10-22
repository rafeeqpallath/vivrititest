package vivriti.groceryapp.sales.domain;

import java.util.ArrayList;
import java.util.List;

import vivriti.groceryapp.invent.domain.Item;

public class SalesCartItem {
	
	private Item item;
	private long quantity;
	private double saleAmount;
	private List<Discount> discounts;
	private double totalDiscount=0;
	private double netAmount;
	
	public SalesCartItem(Item item) {
		this.item=item;
	}
	

	public Item getItem() {
		return this.item;
	}
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
		this.saleAmount = (this.item.getPrice() * this.quantity);
	}
	
	public double getSaleAmount() {
		return this.saleAmount;
	}

	public void addDiscount(Discount discount) {
		if (this.discounts == null) {
			this.discounts = new ArrayList<Discount>();
		}
		this.discounts.add(discount);
		this.totalDiscount += discount.getAmount();
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	public List<Discount> getDiscounts() {
		return discounts;
	}


	public double getTotalDiscount() {
		return totalDiscount;
	}
	
	@Override 
	public String toString() {
		return (this.getItem().toString() + ", Quantity:"+this.getQuantity()+", Sale Amount:"+this.getSaleAmount()
		+", Total Discount:"+this.getTotalDiscount()+", Net Amount:"+this.getNetAmount());
	}

	
}
