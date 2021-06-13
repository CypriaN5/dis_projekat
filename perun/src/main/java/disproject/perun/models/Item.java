package disproject.perun.models;

import java.io.Serializable;

public class Item implements Serializable {

	private String ean13;
	private String itemName;
	private Integer quantity;
	private Integer unitPrice;
	private Integer totalPrice;	

	public Item() {
		super();
	}

	public Item(String ean13, String itemName, Integer quantity, Integer unitPrice, Integer totalPrice) {
		super();
		this.ean13 = ean13;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}

	public String getEan13() {
		return ean13;
	}

	public void setEan13(String ean13) {
		this.ean13 = ean13;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}	
	
}
