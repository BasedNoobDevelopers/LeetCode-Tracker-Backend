package com.acompletenoobsmoke.leetcodetrackerbackend.mapper;

import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountDTO;
import com.acompletenoobsmoke.leetcodetrackerbackend.dto.AccountRegistration;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Account;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.ROLES;

import java.util.function.Supplier;

public class AccountMapper {


    private static Account mapAccountFromRegistration(AccountRegistration accountRegistration) {
        Account account = new Account();
        account.setUserName(accountRegistration.getUserName());
        account.setPassword(accountRegistration.getPassword());
        account.setEmail(accountRegistration.getEmail());
        account.setFirstName(accountRegistration.getFirstName());
        account.setLastName(accountRegistration.getLastName());
        account.setLanguage(accountRegistration.getLanguage());
        account.setRole(ROLES.USER);
        return account;
    }

    private static AccountDTO mapAccountDTO(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getUserName(),
                account.getEmail(),
                account.getRole(),
                account.getLanguage()
        );
    }

    public static Supplier<Account> mapAccountFromRegistrationSupplier(AccountRegistration accountRegistration) {
        return  () -> mapAccountFromRegistration(accountRegistration);
    }

    public static Supplier<AccountDTO> mapAccountDTOSupplier(Account account) {
        return  () -> mapAccountDTO(account);
    }
}
