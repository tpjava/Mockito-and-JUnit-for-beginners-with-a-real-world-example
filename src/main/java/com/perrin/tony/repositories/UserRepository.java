package com.perrin.tony.repositories;

import com.perrin.tony.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
}
