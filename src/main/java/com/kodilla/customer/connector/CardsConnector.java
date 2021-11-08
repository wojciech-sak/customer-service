package com.kodilla.customer.connector;

import com.kodilla.customer.controller.response.GetCardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@FeignClient(name = "cards", fallback = CardsConnectorFallback.class)
public interface CardsConnector {
    @GetMapping("/v1/cards")
    GetCardsResponse getCustomerCards(@RequestParam("customerId") Long customerId);
}

@Slf4j
@Component
class CardsConnectorFallback implements CardsConnector {
    @Override
    public GetCardsResponse getCustomerCards(Long customerId) {
        log.warn("Cannot get cards for customerId: {}", customerId);
        return new GetCardsResponse(Collections.emptyList());
    }
}