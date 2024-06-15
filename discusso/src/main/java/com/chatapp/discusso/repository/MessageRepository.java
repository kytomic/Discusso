package com.chatapp.discusso.repository;

import com.chatapp.discusso.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
