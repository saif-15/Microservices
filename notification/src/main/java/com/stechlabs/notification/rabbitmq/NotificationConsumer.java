package com.stechlabs.notification.rabbitmq;

import com.stechlabs.clients.notification.NotificationRequest;
import com.stechlabs.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener( queues = "${rabbitmq.queue.notification}" )
    public void consume( NotificationRequest notificationRequest ){
        log.info("Consume : {}",  notificationRequest );
        notificationService.createNotification( notificationRequest );
    }
}
