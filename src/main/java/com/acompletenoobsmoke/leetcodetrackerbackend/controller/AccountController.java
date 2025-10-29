package com.acompletenoobsmoke.leetcodetrackerbackend.controller;


import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountDTO;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Account;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.User;
import com.acompletenoobsmoke.leetcodetrackerbackend.service.AccountService;
import com.acompletenoobsmoke.leetcodetrackerbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService userService;

    @GetMapping("/me")
    public ResponseEntity<AccountDTO> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentAccount());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        return ResponseEntity.ok(userService.getAllAccounts());
    }
}
