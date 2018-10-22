package vivriti.groceryapp.invent.domain;

import java.util.List;

public class Item {
	
	private String itemcode;
	private String itemname;
	private String itemdesc;
	private float price;
	private List<ItemCategory> cats;
	
	public Item(String itemcode, String itemname, String itemdesc,float price, List<ItemCategory> cats) {
		this.setItemcode(itemcode);
		this.setItemname(itemname);
		this.setItemdesc(itemdesc);
		this.setCats(cats);
		this.setPrice(price);
	}
	
	public Item(String itemcode, String itemname, String itemdesc, float price) {
		this(itemcode, itemname, itemdesc,price, null);
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	public List<ItemCategory> getCats() {
		return cats;
	}
	public void setCats(List<ItemCategory> cats) {
		this.cats = cats;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//overriding the default toString method in Object
	@Override
	public String toString() {
		return (this.itemcode + ":" + this.itemname);
	}

	//2 items matches if their code matches
	public boolean equalIgnoreCase(Item it) {
		 return (this.itemcode.equalsIgnoreCase(it.itemcode));
	}
	
	//explicit matching with name if needed
	public boolean equalWithName(String s) {
		return (this.getItemname().equalsIgnoreCase(s));
	}
	
	//explicit matching with code if needed
	public boolean equalWithCode (String c) {
		return (this.getItemcode().equalsIgnoreCase(c));
	}
	

}
