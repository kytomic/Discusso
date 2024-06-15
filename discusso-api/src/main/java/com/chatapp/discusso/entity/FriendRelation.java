package com.chatapp.discusso.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "FriendRelation")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FriendRelation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name = "userId1")
    public int userId1;

    @Column(name = "userId2")
    public int userId2;

    @Column(name = "created_at")
    public Date created_at;

    @Column(name = "status")
    public boolean status;
}
