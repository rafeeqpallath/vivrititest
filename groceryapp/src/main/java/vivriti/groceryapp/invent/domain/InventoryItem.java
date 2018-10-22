package vivriti.groceryapp.invent.domain;

public class InventoryItem {
	private Item item;
	private long quantity;
	public InventoryItem(Item it) {
		this(it,0);
	}
	public InventoryItem(Item it, long quantity) {
		this.item = it;
		this.quantity = quantity;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public void addQuantity(long quantity) {
		this.quantity += quantity;
	}
	public void reduceQuantity(long quantity) {
		this.quantity -= quantity;
	}
	@Override
	public String toString() {
		
	   return (this.getItem().toString() + ", Quantity: " + this.getQuantity());
	}

}
