package com.stechlabs.customer;

import com.stechlabs.amqp.RabbitMQMessageProducer;
import com.stechlabs.clients.fraud.FraudCheckResponse;
import com.stechlabs.clients.fraud.FraudClient;
import com.stechlabs.clients.notification.NotificationClient;
import com.stechlabs.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

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
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );
        FraudCheckResponse fraudCheckResponse = fraudClient.checkIsFraudster( customer.getId() );

        if( fraudCheckResponse != null && ! fraudCheckResponse.isFraudster() ){
            NotificationRequest notificationRequest = NotificationRequest.builder()
                    .sentToId( customer.getId() )
                    .content( "Hello from stechlabs" )
                    .sender( "Saif" )
                    .build();

            rabbitMQMessageProducer.produce( notificationRequest , "internal.exchange", "internal.notification.routing-key");
        }
    }

    public Customer find( int customerId ){
        return customerRepository.findById( customerId )
                .orElse( new Customer( ));
    }
}
