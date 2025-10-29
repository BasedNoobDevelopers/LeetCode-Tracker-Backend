package com.acompletenoobsmoke.leetcodetrackerbackend.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountSignIn {

    private String email;
    private String userName;
    private String password;
}
