package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entity.Complaint;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ComplaintRepository;

@Service

public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	ComplaintRepository complaintRepository;
	private static final Logger L=LogManager.getLogger(ComplaintServiceImpl.class);
	@Override
	
	public List<Complaint> retrieveAllComplaint(){
		List<Complaint> complaints=(List<Complaint>) complaintRepository.findAll();
		for(Complaint complaint:complaints){
		L.info("user +++ : "+ complaint);}
		return complaints;
	}

	@Override
	public Complaint addComplaint(Complaint r) {
		return complaintRepository.save(r);
	}

	@Override
	public void deleteComplaint(String id) {
complaintRepository.deleteById(Long.parseLong(id));		
	}

	@Override
	public Complaint updateComplaint(Complaint r) {
		return complaintRepository.save(r);
	}

	@Override
	public Complaint retrieveComplaint(String id) {
		Complaint r;
		r=complaintRepository.findById(Long.parseLong(id)).orElse(null);
		return r;
	}
    

	
	

}
