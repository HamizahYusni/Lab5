import java.io.Serializable;

public class ItemProduct implements Serializable {
	private int itemProductId;
	private String name;
	private float price;
	
	public void setItemProductId(int itemProductId) {
		itemProductId++;
		this.itemProductId = itemProductId;
	}
	
	public int getItemProductId() {
		return itemProductId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	
}
