package com.stechlabs.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "notification",
        url = "${clients.notification.url}"
)
public interface NotificationClient {

    @PostMapping( value = "/api/v1/notifications")
    void pushNotification( NotificationRequest notificationRequest );

}
