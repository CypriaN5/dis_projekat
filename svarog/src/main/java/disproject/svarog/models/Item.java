package disproject.svarog.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="\"Item\"", schema="public")
public class Item {

	@Id
	private UUID id;
	
	private String vendor;
	
	@Column(name="\"ean13\"")
	private String ean13;
	
	@Column(name="\"itemName\"")
	private String itemName;
	
	@Column(name="\"unitPrice\"")
	private Integer unitPrice;
	
	private boolean discounted;
	
	@Column(name="\"discountAmount\"")
	private Integer discountAmount;
	
	@Column(name="\"createdAt\"")
	private LocalDateTime createdAt;
	
	@Column(name="\"updatedAt\"")
	private LocalDateTime updatedAt;

	
	
	public Item() {
		super();
	}

	public Item(UUID id, String vendor, String ean13, String itemName, Integer unitPrice, boolean discounted,
			Integer discountAmount, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.vendor = vendor;
		this.ean13 = ean13;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.discounted = discounted;
		this.discountAmount = discountAmount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
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

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isDiscounted() {
		return discounted;
	}

	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}

	public Integer getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
