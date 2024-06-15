package com.chatapp.discusso.repository;

import com.chatapp.discusso.entity.FriendRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRelationRepository extends JpaRepository<FriendRelation, Integer> {
}
