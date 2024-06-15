package com.chatapp.discusso.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Notification")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name = "type")
    public String type;

    @Column(name = "userId")
    public int userId;

    @Column(name = "timestamp")
    public String timestamp;

    @Column(name = "body")
    public String body;

    @Column(name = "status")
    public boolean status;
}
