package com.kodilla.customer.dao;

import com.kodilla.customer.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;


    @Test
    void findCustomerById() {
        //Given
        Customer customer = new Customer("John", "Kovalsky");

        //When
        Customer savedCustomer = customerDao.save(customer);

        //Then
        assertEquals(savedCustomer.getLastName(), "Kovalsky");
    }
}