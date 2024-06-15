package com.chatapp.discusso.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "UnsentMessage")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UnsentMessage {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name = "messageId")
    public int messageId;

    @Column(name = "userId")
    public int userId;

    @Column(name = "status")
    public boolean status;
}
