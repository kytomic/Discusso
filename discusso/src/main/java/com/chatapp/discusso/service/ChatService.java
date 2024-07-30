package com.chatapp.discusso.service;

import com.chatapp.discusso.dto.MessageDto;
import com.chatapp.discusso.entity.Message;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    public List<Integer> getChattingFriendId(Integer userId);

    public List<Message> getMessages(Integer userId, Integer friendId);

    public void createMessage(MessageDto messageDto);
}
