package tn.esprit.spring.service;

import tn.esprit.spring.entity.Complaint;

import java.util.List;

public interface ComplaintService {
	List<Complaint> retrieveAllComplaint();

	Complaint addComplaint(Complaint r);

	void deleteComplaint(String id);

	Complaint updateComplaint(Complaint r);

	Complaint retrieveComplaint(String id);

}
