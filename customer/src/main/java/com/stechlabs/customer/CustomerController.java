package com.stechlabs.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping( "/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping( "{customerId}")
    public Customer findCustomer(@PathVariable int customerId ){
        log.info( "fetch customer by", customerId );
        return customerService.find( customerId );
    }

    @PostMapping
    public void registerCustomer( @RequestBody CustomerRegistrationRequest customerRegistrationRequest ){
        log.info( "new customer registration {}", customerRegistrationRequest );
        customerService.registerCustomer( customerRegistrationRequest );

    }
}
