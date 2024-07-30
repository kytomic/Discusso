package com.chatapp.discusso.mapper;

import com.chatapp.discusso.dto.MessageDto;
import com.chatapp.discusso.entity.Message;

public class MessageMapper {
    public static MessageDto mapToMessageDto(Message message) {
        return new MessageDto(message.getBody(), message.getSenderId(), message.getReceiverId(), message.getTimestamp());
    }

    public static Message mapToMessage(MessageDto messageDto) {
        return new Message(messageDto.getBody(), messageDto.getSenderId(), messageDto.getReceiverId(), messageDto.getTimestamp());
    }
}
