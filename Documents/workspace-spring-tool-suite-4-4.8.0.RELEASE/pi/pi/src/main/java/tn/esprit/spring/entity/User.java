package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)


public abstract class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id; // Clé primaire
	private String firstName;
	private String lastName;
	private String Password;
	private Double IdC;
	private Double Number;
	private String Email;

	public User() {

	}

	public User(long id, String firstName, String lastName, String password, Double idC, Double number, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Password = password;
		IdC = idC;
		Number = number;
		Email = email;
	}
	

	public User(String firstName, String lastName, String password, Double idC, Double number, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Password = password;
		IdC = idC;
		Number = number;
		Email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Double getIdC() {
		return IdC;
	}

	public void setIdC(Double idC) {
		IdC = idC;
	}

	public Double getNumber() {
		return Number;
	}

	public void setNumber(Double number) {
		Number = number;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	@OneToMany(mappedBy = "recieverUser")
	private Set<Message> recievedMessage;
	@OneToMany(mappedBy = "sendUser")
	private Set<Message> sendMessage;
}
