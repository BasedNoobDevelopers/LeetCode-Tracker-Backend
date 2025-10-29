package com.acompletenoobsmoke.leetcodetrackerbackend.repository.real;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);
    Optional<Account> findByUsername(String username);
    Optional<Account> findByEmailAndPassword(String email, String password);
    Optional<Account> findByUsernameAndPassword(String username, String password);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByPassword(String password);
}
