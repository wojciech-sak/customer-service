package com.kodilla.customer.provider;

import com.kodilla.customer.connector.CardsConnector;
import com.kodilla.customer.dto.AccountDto;
import com.kodilla.customer.dto.CardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardsProvider {

    private final CardsConnector cardsConnector;

    public List<CardDto> getCustomerCards(Long customerId) {
        return cardsConnector.getCustomerCards(customerId)
                .getCards()
                .stream()
                .map(cardDto -> new CardDto(
                        cardDto.getId(),
                        cardDto.getCardNum(),
                        cardDto.getCardType(),
                        cardDto.getCustomerId()))
                .collect(Collectors.toList());
    }
}
