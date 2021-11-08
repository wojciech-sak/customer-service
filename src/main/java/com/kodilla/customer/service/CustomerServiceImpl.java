package com.kodilla.customer.service;

import com.kodilla.customer.dao.CustomerDao;
import com.kodilla.customer.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Optional<Customer> getCustomer(Long customerId) {
        return customerDao.findCustomerById(customerId);
    }
}