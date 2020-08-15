package com.perrin.tony.services;

import com.perrin.tony.models.User;
import com.perrin.tony.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }
}
