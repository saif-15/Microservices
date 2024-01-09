package com.stechlabs.notification;

import com.stechlabs.amqp.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {
                "com.stechlabs.notification",
                "com.stechlabs.amqp"
        }
)
@EnableEurekaClient
@AllArgsConstructor
public class NotificationApplication implements CommandLineRunner {

    private NotificationConfig notificationConfig;

    private RabbitMQMessageProducer rabbitMQMessageProducer;

    public static void main(String[] args) {
        SpringApplication.run( NotificationApplication.class );
    }

    @Override
    public void run(String... args) throws Exception {
        rabbitMQMessageProducer.produce( "hello", notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());
    }
}
