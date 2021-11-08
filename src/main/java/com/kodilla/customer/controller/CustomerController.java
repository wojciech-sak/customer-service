package com.kodilla.customer.controller;

import com.kodilla.customer.controller.response.GetCustomerProductsResponse;
import com.kodilla.customer.controller.response.GetCustomerResponse;
import com.kodilla.customer.domain.Customer;
import com.kodilla.customer.dto.AccountDto;
import com.kodilla.customer.dto.CardDto;
import com.kodilla.customer.dto.CustomerDto;
import com.kodilla.customer.mapper.CustomerMapper;
import com.kodilla.customer.service.CustomerService;
import com.kodilla.customer.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final ProductService productService;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper, ProductService productService) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.productService = productService;
    }


    @GetMapping
    public GetCustomerResponse getCustomerAccounts(@RequestParam Long idCustomer) {
        Customer customer = customerService.getCustomer(idCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new GetCustomerResponse(customerMapper.mapToCustomerDto(customer));
    }

    @GetMapping("/{customerId}/products")
    public GetCustomerProductsResponse getCustomerProducts(@PathVariable Long customerId) {
        CustomerDto customerDto = customerMapper.mapToCustomerDto(customerService.getCustomer(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST)));

        List<AccountDto> customerAccounts = productService.findCustomerAccounts(customerId);
        List<CardDto> customerCards = productService.findCustomerCards(customerId);

        return GetCustomerProductsResponse.builder()
                .customerId(customerDto.getId())
                .fullName(customerDto.getFirstName() + " " + customerDto.getLastName())
                .accounts(customerAccounts)
                .cards(customerCards)
                .build();
    }
}