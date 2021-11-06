package com.kodilla.customer.dao;

import com.kodilla.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long customerId);
}
