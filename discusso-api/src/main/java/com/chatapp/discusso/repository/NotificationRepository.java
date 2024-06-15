package com.chatapp.discusso.repository;

import com.chatapp.discusso.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
