package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("House")

public class House extends Property implements Serializable {
	private String State;
	private Integer NumPiece;
	private String Material;
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Integer getNumPiece() {
		return NumPiece;
	}
	public void setNumPiece(Integer numPiece) {
		NumPiece = numPiece;
	}
	public String getMaterial() {
		return Material;
	}
	public void setMaterial(String material) {
		Material = material;
	}
	
	
	
	public House(long id, Float price, String picture, String address) {
		super(id, price, picture, address);
		// TODO Auto-generated constructor stub
	}
	public House() {
		super();
		
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy="house")
	private Set<Appointment> appointments;
	
	

}
