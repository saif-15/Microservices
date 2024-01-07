package com.stechlabs.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @SequenceGenerator(
            name = "notification_id_seq",
            sequenceName = "notification_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_seq"
    )
    private Integer id;
    private String sender;
    private Integer sentToId;
    private String content;
    private LocalDateTime sendAt;
}
