package com.chatapp.discusso.service;

import com.chatapp.discusso.dto.UserDto;
import com.chatapp.discusso.entity.FriendRelation;
import com.chatapp.discusso.entity.User;
import com.chatapp.discusso.mapper.UserMapper;
import com.chatapp.discusso.repository.FriendRelationRepository;
import com.chatapp.discusso.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRelationRepository friendRelationRepository;

    @Override
    public boolean checkSameAccount(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername()).orElse(null);
        return user != null;
    }

    @Override
    public void createUser(UserDto userDto) {
        userRepository.save(UserMapper.mapToUser(userDto));
    }

    @Override
    public Optional<UserDto> getUserInfo(UserDto userDto) {
        User user = userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword()).orElse(null);
        if (user != null) return Optional.of(UserMapper.mapToUserDto(user));
        return Optional.empty();
    };

    @Override
    public Optional<List<Object[]>> getChattingFriendInfo(List<Integer> id) {
        return userRepository.findUserInfoById(id);
    }

    // Add friends
    // Remove friends
}
