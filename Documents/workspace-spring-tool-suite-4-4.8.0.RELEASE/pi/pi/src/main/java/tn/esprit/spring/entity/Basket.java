package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Basket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long IdCus;
	private long IdProperty;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdCus() {
		return IdCus;
	}
	public void setIdCus(long idCus) {
		IdCus = idCus;
	}
	public long getIdProperty() {
		return IdProperty;
	}
	public void setIdProperty(long idProperty) {
		IdProperty = idProperty;
	}
	public Basket() {
		super();
		
	}
	public Basket(long id, long idCus, long idProperty) {
		super();
		this.id = id;
		IdCus = idCus;
		IdProperty = idProperty;
	}
	@OneToMany
	private Set<Furniture> furnitures;
    @OneToOne(mappedBy = "basket")
    private Customer customer;
}
