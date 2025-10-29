package com.acompletenoobsmoke.leetcodetrackerbackend.service;

import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountDTO;
import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountRegistration;
import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountSignIn;
import com.acompletenoobsmoke.leetcodetrackerbackend.exception.ResourceExistsException;
import com.acompletenoobsmoke.leetcodetrackerbackend.exception.ResourceNotFoundException;
import com.acompletenoobsmoke.leetcodetrackerbackend.mapper.AccountMapper;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Account;
import com.acompletenoobsmoke.leetcodetrackerbackend.repository.real.AccountRepository;
import com.acompletenoobsmoke.leetcodetrackerbackend.utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JWTUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    private void registrationValidation(AccountRegistration accountRegistration) {
        if (accountRepository.existsByEmail(accountRegistration.getEmail())) {
            throw new ResourceExistsException("Email already exists!");
        }
        if (accountRepository.existsByUserName(accountRegistration.getUserName())) {
            throw new ResourceExistsException("Username already exists!");
        }
    }


    public AccountDTO register(AccountRegistration accountRegistration) {
        registrationValidation(accountRegistration);
        String encodedPassword = passwordEncoder.encode(accountRegistration.getPassword());
        accountRegistration.setPassword(encodedPassword);
        Account account = AccountMapper.mapAccountFromRegistrationSupplier(accountRegistration).get();
        Account savedAccount = accountRepository.save(account);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(savedAccount.getUserName());
        String token = jwtUtils.generateToken(userDetails);
        AccountDTO accountDTO = AccountMapper.mapAccountDTOSupplier(savedAccount).get();
        accountDTO.setToken(token);
        return accountDTO;
    }

    public AccountDTO login(AccountSignIn request) {
        Account savedAccount = (request.getUserName() != null) ?
                accountRepository.findByUserName(request.getUserName()).orElseThrow(() -> new ResourceNotFoundException("Username Not Found!"))
                : accountRepository.findByEmail(request.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Email Not Found!"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(savedAccount.getUserName(), request.getPassword())
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(savedAccount.getUserName());
        String token = jwtUtils.generateToken(userDetails);
        AccountDTO accountDTO = AccountMapper.mapAccountDTOSupplier(savedAccount).get();
        accountDTO.setToken(token);
        return accountDTO;
    }

}
