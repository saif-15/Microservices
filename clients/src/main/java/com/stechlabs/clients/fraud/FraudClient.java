package com.stechlabs.clients.fraud;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name= "fraud",
        url = "${clients.fraud.url}"
)
public interface FraudClient {
    @GetMapping("api/v1/fraud-check/{customerId}")
    FraudCheckResponse checkIsFraudster(@PathVariable("customerId") Integer customerId );
}
