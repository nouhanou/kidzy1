package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class GuarenteeFolder implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	private String pieceOfIdentity;
	private String EngagementLetter;
	private String ProofPayement;
	private Boolean Approved;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPieceOfIdentity() {
		return pieceOfIdentity;
	}
	public void setPieceOfIdentity(String pieceOfIdentity) {
		this.pieceOfIdentity = pieceOfIdentity;
	}
	public String getEngagementLetter() {
		return EngagementLetter;
	}
	public void setEngagementLetter(String engagementLetter) {
		EngagementLetter = engagementLetter;
	}
	public String getProofPayement() {
		return ProofPayement;
	}
	public void setProofPayement(String proofPayement) {
		ProofPayement = proofPayement;
	}
	public Boolean getApproved() {
		return Approved;
	}
	public void setApproved(Boolean approved) {
		Approved = approved;
	}
	public GuarenteeFolder() {
		
	}
	public GuarenteeFolder(long id, String pieceOfIdentity, String engagementLetter, String proofPayement,
			Boolean approved) {
		super();
		this.id = id;
		this.pieceOfIdentity = pieceOfIdentity;
		EngagementLetter = engagementLetter;
		ProofPayement = proofPayement;
		Approved = approved;
	}
	
	
	
}
