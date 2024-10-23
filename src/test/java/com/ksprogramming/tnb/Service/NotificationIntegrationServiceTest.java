package com.ksprogramming.tnb.Service;

import com.ksprogramming.tnb.Data.NotificationData;
import com.ksprogramming.tnb.Entity.Notification;
import com.ksprogramming.tnb.Entity.User;
import com.ksprogramming.tnb.Repository.NotificationRepository;
import com.ksprogramming.tnb.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-integrationtest.properties")
class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        notificationRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void createNotification() {
        // GIVEN
        User user = userRepository.save(new User("login", "password", true));
        NotificationData notificationData = new NotificationData();
        notificationData.setTitle("New Notification");
        notificationData.setMessage("This is a test notification");
        notificationData.setReadStatus(false);
        notificationData.setSentDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        notificationData.setUserId(user.getId());

        // WHEN
        NotificationData savedNotification = notificationService.createNotification(notificationData);

        // THEN
        NotificationData foundNotification = notificationService.findNotificationById(savedNotification.getId());
        assertEquals(savedNotification.getId(), foundNotification.getId());
        assertEquals(savedNotification.getTitle(), foundNotification.getTitle());
        assertEquals(savedNotification.getMessage(), foundNotification.getMessage());
    }

    @Test
    void findAllNotifications() {
        // GIVEN
        User user = userRepository.save(new User("login", "password", true));
        NotificationData notificationData1 = new NotificationData();
        notificationData1.setTitle("First Notification");
        notificationData1.setMessage("Message 1");
        notificationData1.setReadStatus(false);
        notificationData1.setSentDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        notificationData1.setUserId(user.getId());

        NotificationData notificationData2 = new NotificationData();
        notificationData2.setTitle("Second Notification");
        notificationData2.setMessage("Message 2");
        notificationData2.setReadStatus(false);
        notificationData2.setSentDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        notificationData2.setUserId(user.getId());

        notificationService.createNotification(notificationData1);
        notificationService.createNotification(notificationData2);

        // WHEN
        List<NotificationData> notifications = notificationService.findAllNotifications();

        // THEN
        assertEquals(2, notifications.size());
        assertEquals("First Notification", notifications.get(0).getTitle());
        assertEquals("Second Notification", notifications.get(1).getTitle());
    }

    @Test
    void deleteNotificationById() {
        // GIVEN
        User user = userRepository.save(new User("login", "password", true));
        NotificationData notificationData = new NotificationData();
        notificationData.setTitle("Notification to Delete");
        notificationData.setMessage("This message will be deleted");
        notificationData.setReadStatus(false);
        notificationData.setSentDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        notificationData.setUserId(user.getId());

        NotificationData savedNotification = notificationService.createNotification(notificationData);

        // WHEN
        notificationService.deleteNotificationById(savedNotification.getId());

        // THEN
        assertThrows(Exception.class, () -> notificationService.findNotificationById(savedNotification.getId()));
    }
}
