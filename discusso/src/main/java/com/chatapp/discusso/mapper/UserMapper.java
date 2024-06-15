package com.chatapp.discusso.mapper;

import com.chatapp.discusso.dto.UserDto;
import com.chatapp.discusso.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(user.getUsername(), user.getPassword(), user.getContactNumber(), user.getEmail(), user.iconUrl);
    }

    public static User mapToUser(UserDto user) {
        return new User(user.getUsername(), user.getPassword(), user.getContactNumber(), user.getEmail());
    }
}
