package com.acompletenoobsmoke.leetcodetrackerbackend.service;

import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountDTO;
import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountRegistration;
import com.acompletenoobsmoke.leetcodetrackerbackend.repository.real.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;


    public AccountDTO register(AccountRegistration accountRegistration) {
        if (accountRepository.existsByEmail(accountRegistration.getEmail())) {
            throw
        }
    }

}
