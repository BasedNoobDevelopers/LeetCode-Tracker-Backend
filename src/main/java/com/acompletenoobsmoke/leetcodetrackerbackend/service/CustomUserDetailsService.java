package com.acompletenoobsmoke.leetcodetrackerbackend.service;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.Account;
import com.acompletenoobsmoke.leetcodetrackerbackend.repository.real.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Account account;

        if (usernameOrEmail.contains("@")) {
            account = accountRepository.findByEmail(usernameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + usernameOrEmail));
        } else {
            account = accountRepository.findByUserName(usernameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + usernameOrEmail));
        }

        return User.withUsername(account.getUserName())
                .password(account.getPassword())
                .roles(account.getRole().name())
                .build();
    }

}
