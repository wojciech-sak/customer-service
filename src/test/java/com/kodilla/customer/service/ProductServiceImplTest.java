package com.kodilla.customer.service;

import com.kodilla.customer.dto.AccountDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        properties = {
                "stubrunner.cloud.loadbalancer.enabled=false"
        }
)
//@SpringBootTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {
                "com.kodilla:accounts:+:stubs:9000"
        }
)
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    void findCustomerAccounts() {
        //Given
        Long customerId = 10L;

        //When
        List<AccountDto> accounts = productService.findCustomerAccounts(customerId);

        //Then
        assertEquals(1, accounts.size());
        assertEquals("08897810189710581776778244", accounts.get(0).getNrb());
        assertEquals("PLN", accounts.get(0).getCurrency());
        assertEquals(new BigDecimal("1000.00"), accounts.get(0).getAvailableFunds());
    }
}