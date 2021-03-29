package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
@Data

@Entity

public class Complaint implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private Date date;
	//private String title;
	private String content;
	@Enumerated(EnumType.STRING)
	TypeRec type;
	@Enumerated(EnumType.STRING)
    private Status complaintStatus = Status.PENDING;

	@Column(name="file")
	private String file;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Announcement announcement;
	@ManyToOne
	//@JoinColumn(name = "customer_id")
	@JsonIgnore
	Customer customer;
	
	
	
	public Status getComplaintStatus() {
		return complaintStatus;
	}
	public void setComplaintStatus(Status complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TypeRec getType() {
		return type;
	}
	public void setType(TypeRec type) {
		this.type = type;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Announcement getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Complaint(long id, Date date, String content, TypeRec type, String file, Announcement announcement,
			Customer customer) {
		super();
		this.id = id;
		this.date = date;
		this.content = content;
		this.type = type;
		this.file = file;
		this.announcement = announcement;
		this.customer = customer;
	}
	
	public Complaint(long id, Date date, String content, TypeRec type, String file) {
		super();
		this.id = id;
		this.date = date;
		this.content = content;
		this.type = type;
		this.file = file;
	}
	
	public Complaint(long id, String content, TypeRec type, String file) {
		super();
		this.id = id;
		this.content = content;
		this.type = type;
		this.file = file;
	}
	public Complaint() {
		
	}
	
	
	
	

}
