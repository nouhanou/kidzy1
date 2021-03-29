package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity

public class Subscription implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public Subscription() {}
	public Subscription(long id, Double price, Date startDate, Date eNdDate, Boolean completed) {
		super();
		this.id = id;
		Price = price;
		StartDate = startDate;
		ENdDate = eNdDate;
		this.completed = completed;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getENdDate() {
		return ENdDate;
	}
	public void setENdDate(Date eNdDate) {
		ENdDate = eNdDate;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	private Double Price;
	private Date StartDate;
	private Date ENdDate;
	private Boolean completed;
	@Enumerated(EnumType.STRING)
	SubType subType;
	@ManyToOne
	private Customer customer;
	
	
	

}
