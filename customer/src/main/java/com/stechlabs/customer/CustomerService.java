package com.stechlabs.customer;

import org.springframework.stereotype.Service;


@Service
public record CustomerService( CustomerRepository customerRepository ) {

    public void registerCustomer( CustomerRegistrationRequest registrationRequest ){
        Customer customer = Customer.builder()
                .firstName( registrationRequest.firstName() )
                .lastName( registrationRequest.lastName() )
                .email( registrationRequest.email() )
                .build();
        // save the customer
        customerRepository.save( customer );

    }

    public Customer find( int customerId ){
        return customerRepository.findById( customerId )
                .orElse( new Customer( ));
    }
}
