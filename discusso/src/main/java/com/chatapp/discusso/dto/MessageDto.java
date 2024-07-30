package com.chatapp.discusso.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private String body;
    private int senderId;
    private int receiverId;
    private Date timestamp;
}
