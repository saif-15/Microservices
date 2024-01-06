package com.stechlabs.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer( CustomerRegistrationRequest registrationRequest ){
        Customer customer = Customer.builder()
                .firstName( registrationRequest.firstName() )
                .lastName( registrationRequest.lastName() )
                .email( registrationRequest.email() )
                .build();
        // todo check customer registration email duplication
        // save the customer and populate the id in entity
        customerRepository.saveAndFlush( customer );

        // check is fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if( fraudCheckResponse != null && fraudCheckResponse.isFraudster() ){

            throw new RuntimeException( "Fraudster" );
            // todo send the notification
        }

    }

    public Customer find( int customerId ){
        return customerRepository.findById( customerId )
                .orElse( new Customer( ));
    }
}
