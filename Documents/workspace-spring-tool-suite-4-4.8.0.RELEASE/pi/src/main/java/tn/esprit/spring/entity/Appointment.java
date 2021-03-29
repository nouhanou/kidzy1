package tn.esprit.spring.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Appointment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	private Timestamp dateA;
	private String Address;
	private Boolean Confirmation;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public Appointment(long id, Timestamp dateA, String address, Boolean confirmation) {
		super();
		this.id = id;
		this.dateA = dateA;
		Address = address;
		Confirmation = confirmation;
	}
	public Timestamp getDateA() {
		return dateA;
	}
	public void setDateA(Timestamp dateA) {
		this.dateA = dateA;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Boolean getConfirmation() {
		return Confirmation;
	}
	public void setConfirmation(Boolean confirmation) {
		Confirmation = confirmation;
	}
	public Appointment() {
		super();
		
	}
	@ManyToOne
	Customer customerr;
	@ManyToOne
	House house;

	
	
	
	

}
