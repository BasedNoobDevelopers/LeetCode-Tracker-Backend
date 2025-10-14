package com.acompletenoobsmoke.leetcodetrackerbackend.user;

import java.util.List;

public interface UserDAO {

    User getUser(Long id);
    List<User> getUsers();

}
