package com.chatapp.discusso.resource;

import com.chatapp.discusso.dto.UserDto;
import com.chatapp.discusso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserResource {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(UserDto userDto) {
        return ResponseEntity.ok(userService.getUserInfo(userDto).orElse(null));
    }
}
