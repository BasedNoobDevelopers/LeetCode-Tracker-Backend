package com.acompletenoobsmoke.leetcodetrackerbackend.dao;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.User;

import java.util.List;

public interface UserDAO {

    User getUser(Long id);
    List<User> getUsers();

}
