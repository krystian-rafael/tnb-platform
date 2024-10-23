package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.NotificationData;
import com.ksprogramming.tnb.Entity.Notification;
import com.ksprogramming.tnb.Entity.User;
import com.ksprogramming.tnb.Exception.NotificationNotFoundException;
import com.ksprogramming.tnb.Mapper.NotificationMapper;
import com.ksprogramming.tnb.Repository.NotificationRepository;
import com.ksprogramming.tnb.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository, NotificationMapper notificationMapper, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
        this.userRepository = userRepository;
    }

    public NotificationData createNotification(NotificationData notificationData) {
        User user = userRepository.findById(notificationData.getUserId())
                .orElseThrow(() -> new NotificationNotFoundException("User not found"));
        Notification notification = notificationMapper.toEntity(notificationData, user);
        notificationRepository.save(notification);
        return notificationMapper.toData(notification);
    }

    public NotificationData findNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found"));
        return notificationMapper.toData(notification);
    }

    public List<NotificationData> findAllNotifications() {
        return notificationRepository.findAll()
                .stream()
                .map(notificationMapper::toData)
                .collect(Collectors.toList());
    }

    public void deleteNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found"));
        notificationRepository.delete(notification);
    }
}
