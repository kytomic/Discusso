package com.chatapp.discusso.repository;

import com.chatapp.discusso.entity.UnsentMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnsentMessageRepository extends JpaRepository<UnsentMessage, Integer> {
}
