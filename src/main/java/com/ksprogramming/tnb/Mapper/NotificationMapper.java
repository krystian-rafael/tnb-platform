package com.ksprogramming.tnb.Mapper;

import com.ksprogramming.tnb.Data.NotificationData;
import com.ksprogramming.tnb.Entity.Notification;
import com.ksprogramming.tnb.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public Notification toEntity(NotificationData data, User user) {
        return new Notification(
                data.getId(),
                data.getTitle(),
                data.getMessage(),
                data.isReadStatus(),
                data.getSentDate(),
                data.getReadDate(),
                user
        );
    }

    public NotificationData toData(Notification notification) {
        return new NotificationData(
                notification.getId(),
                notification.getTitle(),
                notification.getMessage(),
                notification.isReadStatus(),
                notification.getSentDate(),
                notification.getReadDate(),
                notification.getUser().getId()
        );
    }
}
