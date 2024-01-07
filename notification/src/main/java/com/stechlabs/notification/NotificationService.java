package com.stechlabs.notification;

import com.stechlabs.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void createNotification( NotificationRequest notificationRequest ){
        // save to db
        Notification notification = Notification.builder()
                        .content( notificationRequest.getContent() )
                        .sender( notificationRequest.getSender() )
                        .sentToId( notificationRequest.getSentToId() )
                        .sendAt( notificationRequest.getSendAt() )
                        .build();
        notificationRepository.save( notification );
    }

}
