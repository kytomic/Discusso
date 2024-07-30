package com.chatapp.discusso.repository;

import com.chatapp.discusso.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);

    // find usernames by userId
    @Query(value = "SELECT id, username FROM User where id in :ids")
    Optional<List<Object[]>> findUserInfoById(List<Integer> ids);
}
