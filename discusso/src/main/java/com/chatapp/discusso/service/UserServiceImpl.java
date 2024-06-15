package com.chatapp.discusso.service;

import com.chatapp.discusso.dto.UserDto;
import com.chatapp.discusso.entity.User;
import com.chatapp.discusso.mapper.UserMapper;
import com.chatapp.discusso.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

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
}
