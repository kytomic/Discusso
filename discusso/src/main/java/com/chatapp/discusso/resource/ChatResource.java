package com.chatapp.discusso.resource;

import com.chatapp.discusso.dto.MessageDto;
import com.chatapp.discusso.entity.Message;
import com.chatapp.discusso.repository.MessageRepository;
import com.chatapp.discusso.service.ChatService;
import com.chatapp.discusso.service.UserService;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class ChatResource {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @MessageMapping("/send")
    @SendTo("/chat/public")
    public MessageDto broadcastMessage(@Payload MessageDto messageDto) throws Exception {
        Thread.sleep(100);
        chatService.createMessage(messageDto);
        return messageDto;
    }

    @GetMapping("/getChattingFriends/{userId}")
    public ResponseEntity<List<Object[]>> getChattingFriends(@PathVariable Integer userId) {
        return ResponseEntity.ok().body(userService.getChattingFriendInfo(chatService.getChattingFriendId(userId)).orElse(null));
    }

    @GetMapping("/getMessages/{userId}/{friendId}")
    public ResponseEntity<List<Message>> getChatMessages(@PathVariable Integer userId, @PathVariable Integer friendId) {
        return ResponseEntity.ok().body(chatService.getMessages(userId, friendId));
    }
}
