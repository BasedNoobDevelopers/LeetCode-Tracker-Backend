package com.acompletenoobsmoke.leetcodetrackerbackend.dto;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.ProgrammingLanguage;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.ROLES;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long id;
    private String userName;
    private String email;
    private ROLES role;
    private ProgrammingLanguage programmingLanguage;
}
