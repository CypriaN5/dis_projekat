package disproject.svarog.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Site\"", schema="public")
public class Site {

	@Id
	private UUID id;
	
	@Column(name="\"simpleSiteId\"")
	private Integer simpleSiteId;
	
	@Column(name="\"city\"")
	private String city;
	
	@Column(name="\"postalCode\"")
	private String postalCode;
	
	@Column(name="\"streetName\"")
	private String streetName;
	
	@Column(name="\"streetNumber\"")
	private String streetNumber;
	
	@Column(name="\"surfaceArea\"")
	private Integer surfaceArea;
	
	@Column(name="\"surfaceAreaUnit\"")
	private String surfaceAreaUnit;
	
	@Column(name="\"createdAt\"")
	private LocalDateTime createdAt;
	
	@Column(name="\"updatedAt\"")
	private LocalDateTime updatedAt;
	
	public Site() {
		super();
	}

	public Site(UUID id, Integer simpleSiteId, String city, String postalCode, String streetName, String streetNumber,
			Integer surfaceArea, String surfaceAreaUnit, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.simpleSiteId = simpleSiteId;
		this.city = city;
		this.postalCode = postalCode;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.surfaceArea = surfaceArea;
		this.surfaceAreaUnit = surfaceAreaUnit;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getSimpleSiteId() {
		return simpleSiteId;
	}

	public void setSimpleSiteId(Integer simpleSiteId) {
		this.simpleSiteId = simpleSiteId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public Integer getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Integer surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getSurfaceAreaUnit() {
		return surfaceAreaUnit;
	}

	public void setSurfaceAreaUnit(String surfaceAreaUnit) {
		this.surfaceAreaUnit = surfaceAreaUnit;
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
