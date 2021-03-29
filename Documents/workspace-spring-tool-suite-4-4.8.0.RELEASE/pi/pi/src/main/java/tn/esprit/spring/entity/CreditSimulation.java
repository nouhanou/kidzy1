package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class CreditSimulation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id; // Clé primaire
	private Double toBeBorrowed;
	private Double PropertyPrice;
	private Integer duration;
	private float CreditAmount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getToBeBorrowed() {
		return toBeBorrowed;
	}
	public void setToBeBorrowed(Double toBeBorrowed) {
		this.toBeBorrowed = toBeBorrowed;
	}
	public Double getPropertyPrice() {
		return PropertyPrice;
	}
	public void setPropertyPrice(Double propertyPrice) {
		PropertyPrice = propertyPrice;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public float getCreditAmount() {
		return CreditAmount;
	}
	public void setCreditAmount(float creditAmount) {
		CreditAmount = creditAmount;
	}
	public CreditSimulation() {
		
	}
	public CreditSimulation(long id, Double toBeBorrowed, Double propertyPrice, Integer duration, float creditAmount) {
		super();
		this.id = id;
		this.toBeBorrowed = toBeBorrowed;
		PropertyPrice = propertyPrice;
		this.duration = duration;
		CreditAmount = creditAmount;
	}

}
