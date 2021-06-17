package disproject.dabog.models;

import java.time.LocalDateTime;
import java.util.List;
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

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name="\"PaymentTransaction\"", schema="public")
public class PaymentTransaction {
	
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(
	        name = "\"cardId\"",
	        referencedColumnName = "\"id\""
	    )
	@JsonIgnore
	private Card card;
	
	@JsonInclude()
	@Transient
	private UUID cardId;
	
	@Column(name="\"paymentRefId\"")
	private String paymentRefId;
	
	@Column(name="\"amount\"")
	private Integer amount;
	
	@Column(name="\"currency\"")
	private String currency;
	
	@Type(type = "jsonb")
    @Column(name="\"invoiceData\"", columnDefinition = "jsonb")
	private List<Object> invoiceData;
	
	@Column(name="\"createdAt\"")
	private LocalDateTime createdAt;
	
	@Column(name="\"updatedAt\"")
	private LocalDateTime updatedAt;

	public PaymentTransaction() {
		super();
	}

	public PaymentTransaction(UUID id, User user, UUID userId, Card card, UUID cardId, String paymentRefId,
			Integer amount, List<Object> invoiceData, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.userId = userId;
		this.card = card;
		this.cardId = cardId;
		this.paymentRefId = paymentRefId;
		this.amount = amount;
		this.invoiceData = invoiceData;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	
	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UUID getUserId() {
		return user.getId();
	}


	public void setUserId(User user) {
		this.userId = user.getId();
	}


	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}


	public UUID getCardId() {
		return card.getId();
	}


	public void setCardId(Card card) {
		this.cardId = card.getId();
	}


	public String getPaymentRefId() {
		return paymentRefId;
	}


	public void setPaymentRefId(String paymentRefId) {
		this.paymentRefId = paymentRefId;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Object> getInvoiceData() {
		return invoiceData;
	}


	public void setInvoiceData(List<Object> invoiceData) {
		this.invoiceData = invoiceData;
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
