package com.acompletenoobsmoke.leetcodetrackerbackend.service.fake;

import com.acompletenoobsmoke.leetcodetrackerbackend.dao.UserDAO;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.User;
import com.acompletenoobsmoke.leetcodetrackerbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFakeService implements UserService {


    private final UserDAO userDAO;

    public UserFakeService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }
}
