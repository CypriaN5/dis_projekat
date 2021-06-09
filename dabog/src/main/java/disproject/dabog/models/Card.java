package disproject.dabog.models;

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
@Table(name="\"Card\"")
public class Card {

	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
	        name = "\"userId\"",
	        referencedColumnName = "\"id\""
	    )
	@JsonIgnore
	private User user;
	
	@JsonInclude()
	@Transient
	private UUID userId;
	
	@Column(name="\"cardType\"")
	private String cardType;
	
	@Column(name="\"cardBinNumber\"")
	private String cardBinNumber;
	
	@Column(name="\"lastFourDigits\"")
	private String lastFourDigits;
	
	@Column(name="\"isDeleted\"")
	private boolean isDeleted;
	
	@Column(name="\"createdAt\"")
	private LocalDateTime createdAt;
	
	@Column(name="\"updatedAt\"")
	private LocalDateTime updatedAt;

	public Card() {
		super();
	}

	public Card(UUID id, User user, String cardType, String cardBinNumber, String lastFourDigits, boolean isDeleted,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.user = user;
		//this.userId = userId;
		this.cardType = cardType;
		this.cardBinNumber = cardBinNumber;
		this.lastFourDigits = lastFourDigits;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	
	public UUID getUserId() { 
		 return user.getId();
	}
	
	public void setUserId(User user) { 
		 this.userId = user.getId(); 
	}
	 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardBinNumber() {
		return cardBinNumber;
	}

	public void setCardBinNumber(String cardBinNumber) {
		this.cardBinNumber = cardBinNumber;
	}

	public String getLastFourDigits() {
		return lastFourDigits;
	}

	public void setLastFourDigits(String lastFourDigits) {
		this.lastFourDigits = lastFourDigits;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
