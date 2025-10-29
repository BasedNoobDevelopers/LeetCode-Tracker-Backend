package com.acompletenoobsmoke.leetcodetrackerbackend.service;

import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountDTO;
import com.acompletenoobsmoke.leetcodetrackerbackend.exception.ResourceForbiddenException;
import com.acompletenoobsmoke.leetcodetrackerbackend.exception.ResourceNotFoundException;
import com.acompletenoobsmoke.leetcodetrackerbackend.mapper.AccountMapper;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Account;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.ROLES;
import com.acompletenoobsmoke.leetcodetrackerbackend.repository.real.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountDTO getCurrentAccount() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return AccountMapper.mapAccountDTOSupplier(account).get();
    }

    public List<AccountDTO> getAllAccounts() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        Account savedAccount = accountRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//        ROLES currentRole = savedAccount.getRole();
//        if (currentRole != null && currentRole != ROLES.ADMIN)
//            throw new ResourceForbiddenException("Only Admin Can Access Accounts");
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (Account account : accounts) {
            accountDTOS.add(AccountMapper.mapAccountDTOSupplier(account).get());
        }
        return accountDTOS;
    }

}
