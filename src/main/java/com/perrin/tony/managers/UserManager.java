package com.perrin.tony.managers;

import com.perrin.tony.models.User;
import com.perrin.tony.services.UserService;

import java.util.List;

public class UserManager {
    private UserService userService;

    public UserManager(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
