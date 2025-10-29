package com.acompletenoobsmoke.leetcodetrackerbackend.dto;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.ProgrammingLanguage;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountRegistration {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private ProgrammingLanguage language;
}
