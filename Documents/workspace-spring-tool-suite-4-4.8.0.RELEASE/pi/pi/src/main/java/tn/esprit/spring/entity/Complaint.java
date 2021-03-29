package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Complaint implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	private String title;
	private String content;
	@ManyToOne(cascade = CascadeType.ALL)
	Announcement announcement;
	@ManyToOne
	Customer customer;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
//	@ManyToOne
//	@JoinColumn(name="idAnnonce",referencedColumnName = "id",insertable = false,updatable = false)
//	public Announcement getAnnonce() {
//		return annonce;
//	}
//	public void setAnnonce(Announcement annonce) {
//		this.annonce = annonce;
//	}
	public Complaint(long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public Complaint() {
		
	}
	
	
	
	

}
