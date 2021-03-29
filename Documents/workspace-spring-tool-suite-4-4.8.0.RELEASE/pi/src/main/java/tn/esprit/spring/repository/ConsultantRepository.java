package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Consultant;

public interface ConsultantRepository extends CrudRepository<Consultant, Long> {

}
