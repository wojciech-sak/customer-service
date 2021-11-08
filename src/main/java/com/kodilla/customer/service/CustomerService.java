package com.kodilla.customer.service;

import com.kodilla.customer.domain.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getCustomer(Long customerId);
}
