package com.acompletenoobsmoke.leetcodetrackerbackend.service;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUser(Long id);
}
