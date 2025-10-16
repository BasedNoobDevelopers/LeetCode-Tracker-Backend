package com.acompletenoobsmoke.leetcodetrackerbackend.repository.fake;

import com.acompletenoobsmoke.leetcodetrackerbackend.dao.UserDAO;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserFakeRepo implements UserDAO {

    private static List<User> users;
    private static AtomicLong nextId = new AtomicLong(1);

    static {
        users = new ArrayList<>();
        users.add(new User(nextId.getAndIncrement(), "Ade", "Uwensuyi", "Python"));
        users.add(new User(nextId.getAndIncrement(), "Boye", "Uwensuyi", "Python"));
        users.add(new User(nextId.getAndIncrement(), "Omoruyi", "Omofonmwan", "Java"));
    }

    @Bean
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " does not exist"));
    }


}
