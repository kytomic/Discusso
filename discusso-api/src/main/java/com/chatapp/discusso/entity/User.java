package com.chatapp.discusso.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="User")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "email")
    public String email;

    @Column(name = "contactNumber")
    public String contactNumber;

    @Column(name = "createdAt")
    public LocalDateTime createdAt;

    @Column(name = "modifiedAt")
    public LocalDateTime modifiedAt;

    @Column(name = "iconUrl")
    public String iconUrl;

    @Column(name = "status")
    public boolean status;

    public User(String username, String password, String contactNumber, String email) {
        this.username = username;
        this.password = password;
        this.contactNumber = contactNumber;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.status = true;
    }
}
