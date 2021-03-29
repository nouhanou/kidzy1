package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Complaint;
import tn.esprit.spring.entity.Message;


public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
	

}
