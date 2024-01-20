package com.stechlabs.notification;

import com.stechlabs.amqp.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {
                "com.stechlabs.notification",
                "com.stechlabs.amqp"
        }
)
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
@EnableEurekaClient
@AllArgsConstructor
public class NotificationApplication  {

    public static void main(String[] args) {
        SpringApplication.run( NotificationApplication.class );
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
//                                        NotificationConfig config){
//        return args -> {
//            producer.produce( "foo", config.getInternalExchange(), config.getInternalNotificationRoutingKey() );
//        };
//    }
}
