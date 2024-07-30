package com.chatapp.discusso.service;

import com.chatapp.discusso.dto.MessageDto;
import com.chatapp.discusso.entity.Message;
import com.chatapp.discusso.mapper.MessageMapper;
import com.chatapp.discusso.repository.MessageRepository;
import com.chatapp.discusso.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Integer> getChattingFriendId(Integer userId) {
        Optional<List<Integer>> senderList = messageRepository.findChattingFriendsIdBySenderId(userId);
        Optional<List<Integer>> receiverList = messageRepository.findChattingFriendsIdByReceiverId(userId);
        List<Integer> result;

        if (senderList.isPresent() && receiverList.isPresent()) {
            Set<Integer> set = new HashSet<>();
            set.addAll(senderList.get());
            set.addAll(receiverList.get());
            result = new ArrayList<>(set);
        } else result = senderList.orElseGet(() -> receiverList.orElse(null));

        return result;
    }

    @Override
    public List<Message> getMessages(Integer userId, Integer friendId) {
        return messageRepository.findAllMessages(userId, friendId).orElse(null);
    }

    @Override
    public void createMessage(MessageDto messageDto) {
        messageRepository.save(MessageMapper.mapToMessage(messageDto));
    }
}
