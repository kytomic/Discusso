package com.chatapp.discusso.repository;

import com.chatapp.discusso.entity.ChatGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatGroupRepository extends JpaRepository<ChatGroup, Integer> {
}
