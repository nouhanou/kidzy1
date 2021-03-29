package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
//@DiscriminatorValue(value = "Consultant")

public class Consultant extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Domain;
	private Double Salary;

	public Consultant() {
		super();

	}

	public Consultant(long id, String firstName, String lastName, String password, Double idC, Double number,
			String email) {
		super(id, firstName, lastName, password, idC, number, email);
		// TODO Auto-generated constructor stub
	}

	public Consultant(String firstName, String lastName, String password, Double idC, Double number, String email) {
		super(firstName, lastName, password, idC, number, email);
		// TODO Auto-generated constructor stub
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

}
