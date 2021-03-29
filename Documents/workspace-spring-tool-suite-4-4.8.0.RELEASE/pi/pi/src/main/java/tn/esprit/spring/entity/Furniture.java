package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Furniture")


public class Furniture extends Property implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private String Type;
	private String State;
	public Furniture() {
		
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Furniture(long id, Float price, String picture, String address) {
		super(id, price, picture, address);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
