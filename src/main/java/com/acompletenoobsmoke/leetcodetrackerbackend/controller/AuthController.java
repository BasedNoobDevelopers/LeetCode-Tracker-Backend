package com.acompletenoobsmoke.leetcodetrackerbackend.controller;

import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountDTO;
import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountRegistration;
import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountSignIn;
import com.acompletenoobsmoke.leetcodetrackerbackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AccountDTO> login(@RequestBody AccountSignIn accountSignIn) {
        return ResponseEntity.ok(authService.login(accountSignIn));
    }

    @PostMapping("/register")
    public ResponseEntity<AccountDTO> register(@RequestBody AccountRegistration accountRegistration) {
        return ResponseEntity.ok(authService.register(accountRegistration));
    }
}
