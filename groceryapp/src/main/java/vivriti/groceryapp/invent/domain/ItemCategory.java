package vivriti.groceryapp.invent.domain;

public class ItemCategory {

	private String code;
	private String name;
	private String desc;

	public ItemCategory(String code, String name, String desc) {
		this.code = code;
		this.setName(name);
		this.setDesc(desc);
	}
	
	public boolean equalIgnoreCase(ItemCategory s) {
		if (this.code.equalsIgnoreCase(s.code)) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
