package com.chatapp.discusso.service;

import com.chatapp.discusso.dto.UserDto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public boolean checkSameAccount(UserDto userDto);

    public void createUser(UserDto userDto);

    public Optional<UserDto> getUserInfo(UserDto userDto);

    public Optional<List<Object[]>>  getChattingFriendInfo(List<Integer> id);
}
