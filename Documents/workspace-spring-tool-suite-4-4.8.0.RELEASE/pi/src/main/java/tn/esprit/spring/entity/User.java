package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.Module.SetupContext;

import tn.esprit.spring.constraint.FieldMatch;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
@FieldMatch(first = "password", second = "confirm_password", message = "Password and Confirm Password miss matched.")



@Table(name="user")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type",visible = true)
@JsonSubTypes({ @Type(value = Customer.class, name = "customer"), @Type(value = Consultant.class, name = "consultant"),
		@Type(value = Admin.class, name = "admin") })

public  class User implements Serializable {
	/**
	 * 
	 */
	//@Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Customer.class, User.class);

        // and other set up, if any
    }
	
	private static final long serialVersionUID = 1L;
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id; // Clé primaire
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String username;
	@NotBlank
	private String Password;
	@NotBlank
	private String ConfirmPassword;
	//@NotBlank
	private Double IdC;
	//@NotBlank
	private Double Number;
	@NotBlank
	@javax.validation.constraints.Email
	@Column(unique = true)
	private String email;
	@JsonIgnore
	@JsonProperty(value = "type")
	private String type;
	private Boolean enabled;
	private String authority;
	
	

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	public String getType() {
		return type;
	}

	
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

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
		email = email;
	}

	public User(String firstName, String lastName, String password, Double idC, Double number, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Password = password;
		IdC = idC;
		Number = number;
		email = email;
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

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", Password=" + Password + ", ConfirmPassword=" + ConfirmPassword + ", IdC=" + IdC + ", Number="
				+ Number + ", email=" + email + ", type=" + type + ", enabled=" + enabled + ", authority=" + authority
				+ ", messages=" + messages + "]";
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Message> messages ;

	/*
	 * @OneToMany(mappedBy = "recieverUser") private Set<Message> recievedMessage;
	 * 
	 * @OneToMany(mappedBy = "sendUser") private Set<Message> sendMessage;
	 */
}
