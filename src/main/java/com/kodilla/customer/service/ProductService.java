package com.kodilla.customer.service;

import com.kodilla.customer.dto.AccountDto;
import com.kodilla.customer.dto.CardDto;

import java.util.List;

public interface ProductService {
    List<AccountDto> findCustomerAccounts(Long customerId);

    List<CardDto> findCustomerCards(Long customerId);
}
