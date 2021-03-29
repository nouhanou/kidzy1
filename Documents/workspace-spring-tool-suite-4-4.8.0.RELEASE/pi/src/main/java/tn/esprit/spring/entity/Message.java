package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
@Data


@Entity

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	private String Contents;
	private Boolean seen = false;

    private LocalDateTime receivedDate;
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getContents() {
		return Contents;
	}



	public void setContents(String contents) {
		Contents = contents;
	}



	



	public Boolean getSeen() {
		return seen;
	}



	public void setSeen(Boolean seen) {
		this.seen = seen;
	}



	public LocalDateTime getReceivedDate() {
		return receivedDate;
	}



	public void setReceivedDate(LocalDateTime receivedDate) {
		this.receivedDate = receivedDate;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@ManyToOne
	
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	/*@ManyToOne
	private User sendUser;*/
	
	 
	

}
