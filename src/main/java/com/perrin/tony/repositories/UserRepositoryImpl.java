package com.perrin.tony.repositories;

import com.perrin.tony.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            List<User> users = new ArrayList<>();

            while(resultSet.next()) {
                users.add(new User(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting users from database.");
        }
    }
}
