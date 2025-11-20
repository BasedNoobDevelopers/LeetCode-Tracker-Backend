package com.acompletenoobsmoke.leetcodetrackerbackend.dto;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.ProgrammingLanguage;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountRegistration implements Serializable {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private ProgrammingLanguage language;
    private MultipartFile file;
}
