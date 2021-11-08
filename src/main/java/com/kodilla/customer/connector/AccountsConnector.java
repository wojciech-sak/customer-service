package com.kodilla.customer.connector;

import com.kodilla.customer.controller.response.GetAccountsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "accounts", fallback = AccountsConnectorFallback.class)
@FeignClient(name = "accounts")
public interface AccountsConnector {
    @GetMapping("/v1/accounts")
    GetAccountsResponse getCustomerAccounts(@RequestParam("customerId") Long customerId);
}

//@Slf4j
//@Component
//class AccountsConnectorFallback implements AccountsConnector {
//    @Override
//    public GetAccountsResponse getAccounts(Long customerId) {
//        log.warn("Cannot get accounts for customerId: {}", customerId);
//        return new GetAccountsResponse(Collections.emptyList());
//    }
//}