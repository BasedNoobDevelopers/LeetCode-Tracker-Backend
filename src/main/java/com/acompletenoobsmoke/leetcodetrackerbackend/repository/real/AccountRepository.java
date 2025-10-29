package com.acompletenoobsmoke.leetcodetrackerbackend.repository.real;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.Account;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.ROLES;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);
    Optional<Account> findByUserName(String username);
    Optional<Account> findByEmailAndPassword(String email, String password);
    Optional<Account> findByUserNameAndPassword(String username, String password);
    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
    boolean existsByPassword(String password);
    ROLES getRoleByUserName(String username);
}
