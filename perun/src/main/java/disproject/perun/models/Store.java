package disproject.perun.models;

import java.time.LocalDateTime;
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
@Table(name="\"Store\"", schema="public")
public class Store {
	
	@Id
	private UUID id;
	
	@Column(name="\"simpleStoreId\"")
	private Integer simpleStoreId;
	
	@Column(name="\"storeName\"")
	private String storeName;
	
	@Type(type = "jsonb")
    @Column(name="\"storeInfo\"", columnDefinition = "jsonb")
	private Object storeInfo;
	
	@Column(name="\"createdAt\"")
	private LocalDateTime createdAt;
	
	@Column(name="\"updatedAt\"")
	private LocalDateTime updatedAt;
	
	@Column(name="\"isDeleted\"")
	private boolean isDeleted;

		
	public Store() {
		super();
	}

	public Store(UUID id, Integer simpleStoreId, String storeName, Object storeInfo, LocalDateTime createdAt,
			LocalDateTime updatedAt, boolean isDeleted) {
		super();
		this.id = id;
		this.simpleStoreId = simpleStoreId;
		this.storeName = storeName;
		this.storeInfo = storeInfo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isDeleted = isDeleted;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getSimpleStoreId() {
		return simpleStoreId;
	}

	public void setSimpleStoreId(Integer simpleStoreId) {
		this.simpleStoreId = simpleStoreId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Object getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(Object storeInfo) {
		this.storeInfo = storeInfo;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}	
	
}
