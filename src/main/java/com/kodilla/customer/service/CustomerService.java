package com.kodilla.customer.service;

import com.kodilla.customer.domain.Customer;

public interface CustomerService {
    Customer getCustomer(Long customerId);
}
