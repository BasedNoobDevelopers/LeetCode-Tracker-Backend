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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!accountRepository.existsByUsername(username) || !accountRepository.existsByEmail(username)) {
            throw new UsernameNotFoundException("Invalid username/email or password.");
        }

        Account account = null;
        if (username.contains("@")) {
            account = accountRepository.findByEmail(username).get();
        } else
            account = accountRepository.findByUsername(username).get();

        return User.withUsername(account.getUserName())
                .password(account.getPassword())
                .roles(account.getRole().name())
                .build();
    }
}
