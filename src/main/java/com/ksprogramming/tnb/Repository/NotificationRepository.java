package com.ksprogramming.tnb.Repository;

import com.ksprogramming.tnb.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
