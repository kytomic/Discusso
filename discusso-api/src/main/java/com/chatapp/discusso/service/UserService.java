package com.chatapp.discusso.service;

import com.chatapp.discusso.dto.UserDto;
import com.chatapp.discusso.entity.User;

import java.util.Optional;

public interface UserService {
    public void createUser(UserDto userDto);

    public Optional<UserDto> getUserInfo(UserDto userDto);
}
