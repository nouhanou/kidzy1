package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
//@DiscriminatorValue(value="Customer")
@JsonTypeName("customer")
public class Customer extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String picture;
	private String DescriptionBlock;
	private String Address;
	



	@OneToMany
	private Set<Favoris> favorites;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private Set<Announcement> announcements;
	@OneToOne
	private Favoris Favori;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private Set<Complaint> complaints;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customerr")
	private Set<Appointment> appointments;
    
	
	

	public Customer() {
		super();
		
	}
	
	public Customer(long id, String firstName, String lastName, String password, Double idC, Double number,
			String email) {
		super(id, firstName, lastName, password, idC, number, email);
		// TODO Auto-generated constructor stub
	}

	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescriptionBlock() {
		return DescriptionBlock;
	}
	public void setDescriptionBlock(String descriptionBlock) {
		DescriptionBlock = descriptionBlock;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	
	public Set<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Set<Announcement> announcements) {
		this.announcements = announcements;
	}



	@OneToOne
    private Basket basket;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private Set<Subscription> subscriptions;
	@OneToOne(cascade = CascadeType.ALL)
	private GuarenteeFolder guarenteeFolder;
	
	
}
