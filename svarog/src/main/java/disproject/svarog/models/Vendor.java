package disproject.svarog.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name="\"Vendor\"", schema="public")
public class Vendor implements Serializable {
	
	@Id
	private UUID id;
	
	@Column(name="\"simpleVendorId\"")
	private Integer simpleVendorId;
	
	@Column(name="\"vendorName\"")
	private String vendorName;
	
	@Type(type = "jsonb")
	@Column(name="\"vendorInfo\"", columnDefinition = "jsonb")
	private Object vendorInfo;
	
	@Type(type = "jsonb")
	@Column(name="\"representativeInfo\"", columnDefinition = "jsonb")
	private Object representativeInfo;
	
	@Column(name="\"createdAt\"")
	private LocalDateTime createdAt;
	
	@Column(name="\"updatedAt\"")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="vendor")
	@JsonIgnore
	private List<Item> items;

	public Vendor() {
		super();
	}

	public Vendor(UUID id, Integer simpleVendorId, String vendorName, Object vendorInfo, Object representativeInfo,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.simpleVendorId = simpleVendorId;
		this.vendorName = vendorName;
		this.vendorInfo = vendorInfo;
		this.representativeInfo = representativeInfo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getSimpleVendorId() {
		return simpleVendorId;
	}

	public void setSimpleVendorId(Integer simpleVendorId) {
		this.simpleVendorId = simpleVendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Object getVendorInfo() {
		return vendorInfo;
	}

	public void setVendorInfo(Object vendorInfo) {
		this.vendorInfo = vendorInfo;
	}

	public Object getRepresentativeInfo() {
		return representativeInfo;
	}

	public void setRepresentativeInfo(Object representativeInfo) {
		this.representativeInfo = representativeInfo;
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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
