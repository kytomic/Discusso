package com.chatapp.discusso.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String contactNumber;
    private String iconUrl;
}
