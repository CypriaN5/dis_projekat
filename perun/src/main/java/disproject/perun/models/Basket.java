package disproject.perun.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name="\"Basket\"", schema="public")
public class Basket {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name="\"appUserId\"")
	private UUID appUserId;
	
	private boolean closed;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private List<Item> items;
	
	@Column(name="\"paymentRefId\"")
	private String paymentRefId;
	
	@Column(name="\"storeId\"")
	private Integer storeId;
	
	@Column(name="\"totalPrice\"")
	private Integer totalPrice;
	
	@Column(name="\"receiptNumber\"")
	private String receiptNumber;
	
	@Column(name="\"createdAt\"")
	private LocalDateTime createdAt;
	
	@Column(name="\"updatedAt\"")
	private LocalDateTime updatedAt;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private List<ErrorItem> errors;

	
	public Basket() {
		super();
	}

	public Basket(UUID id, UUID appUserId, boolean closed, List<Item> items, String paymentRefId, Integer totalPrice,
			String receiptNumber, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.appUserId = appUserId;
		this.closed = closed;
		this.items = items;
		this.paymentRefId = paymentRefId;
		this.totalPrice = totalPrice;
		this.receiptNumber = receiptNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(UUID appUserId) {
		this.appUserId = appUserId;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getPaymentRefId() {
		return paymentRefId;
	}

	public void setPaymentRefId(String paymentRefId) {
		this.paymentRefId = paymentRefId;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
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

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public List<ErrorItem> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorItem> errors) {
		this.errors = errors;
	}

}


