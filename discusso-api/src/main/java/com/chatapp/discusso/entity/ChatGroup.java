package com.chatapp.discusso.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "ChatGroup")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChatGroup {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "iconUrl")
    public String iconUrl;

    @Column(name = "status")
    public boolean status;
}
