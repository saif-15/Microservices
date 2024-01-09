package com.stechlabs.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void produce( Object payload, String exchange, String routingKey ){
        log.info( "payload : {}, exchange :{}, key : {}", payload, exchange, routingKey );
        amqpTemplate.convertAndSend( exchange, routingKey, payload );
    }
}
