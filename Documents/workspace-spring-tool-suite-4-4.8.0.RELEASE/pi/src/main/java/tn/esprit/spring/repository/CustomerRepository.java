package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
