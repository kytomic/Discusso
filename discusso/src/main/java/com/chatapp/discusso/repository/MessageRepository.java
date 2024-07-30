package com.chatapp.discusso.repository;

import com.chatapp.discusso.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query(value = "(SELECT sender_id FROM Message WHERE receiver_id = ?1)", nativeQuery = true)
    Optional<List<Integer>> findChattingFriendsIdBySenderId(Integer userId);

    @Query(value = "(SELECT receiver_id FROM Message WHERE sender_id = ?1)", nativeQuery = true)
    Optional<List<Integer>> findChattingFriendsIdByReceiverId(Integer userId);

    @Query(value = "(SELECT * FROM Message WHERE sender_id IN (:userId, :friendId) " +
            "AND receiver_id IN (:userId, :friendId) " +
            "AND sender_id != receiver_id)", nativeQuery = true)
    Optional<List<Message>> findAllMessages(Integer userId, Integer friendId);
}
