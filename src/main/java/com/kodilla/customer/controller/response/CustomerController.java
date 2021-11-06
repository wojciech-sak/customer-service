package com.kodilla.customer.controller.response;

import com.kodilla.customer.mapper.CustomerMapper;
import com.kodilla.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }


    @GetMapping
    public GetCustomerResponse getCustomerAccounts(@RequestParam Long idCustomer) {
        return new GetCustomerResponse(
                customerMapper.mapToCustomerDto(customerService.getCustomer(idCustomer)));
    }
}