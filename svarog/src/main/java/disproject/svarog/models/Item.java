package disproject.svarog.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="\"Item\"", schema="public")
public class Item implements Serializable {

	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
	        name = "vendor",
	        referencedColumnName = "\"vendorName\""
	    )
	@JsonIgnore
	private Vendor vendor;
	
	@JsonInclude()
	@Transient
	private String vendorName;
	
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

	@JsonInclude()
	@Transient
	private Integer quantity = 1;
	

	public Item() {
		super();
	}

	public Item(UUID id, Vendor vendor, String ean13, String itemName, Integer unitPrice, boolean discounted,
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

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	public String getVendorName() {
		return vendor.getVendorName();
	}

	public void setVendorName(Vendor vendor) {
		this.vendorName = vendor.getVendorName();
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
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
