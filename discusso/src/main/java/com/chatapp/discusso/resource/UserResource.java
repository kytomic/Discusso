package com.chatapp.discusso.resource;

import com.chatapp.discusso.dto.UserDto;
import com.chatapp.discusso.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserResource {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody UserDto userDto) {
        if (userService.checkSameAccount(userDto))
            return ResponseEntity.ok().body(false);

        userService.createUser(userDto);
        return ResponseEntity.ok().body(true);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userService.getUserInfo(userDto).orElse(null));
    }

    @MessageMapping("/test")
    @SendTo("/chat")
    public boolean testSocket() throws InterruptedException {
        Thread.sleep(100);
        return true;
    }
}
