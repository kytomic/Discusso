package com.chatapp.discusso.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Message")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name = "body")
    public String body;

    @Column(name = "senderId")
    public int senderId;

    @Column(name = "receiverId")
    public int receiverId;

    @Column(name = "timestamp")
    public Date timestamp;

    @Column(name = "status")
    public boolean status;
}
