package com.perrin.tony.services;

import com.perrin.tony.models.User;
import com.perrin.tony.repositories.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserRepository userRepositoryMock;
    private UserService userService;

    @Before
    public void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepositoryMock);
    }

    @Test
    public void shouldReturnUserServiceImplementation() {
        Assert.assertNotNull(userService);
    }

    @Test
    public void shouldReturnListOfAllUsers() {
        List<User> users = Arrays.asList(
                new User("Andrew", "Brown", 51),
                new User("Andrew", "Smith", 51),
                new User("Eric", "Briggs", 72),
                new User("Susan", "Briggs", 68));
        doReturn(users).when(userRepositoryMock).getAllUsers();
        List<User> results = userService.getAllUsers();
        Assert.assertNotNull(results);
        Assert.assertEquals(4, results.size());

        verify(userRepositoryMock, atLeastOnce()).getAllUsers();
    }

    @After
    public void tearDown() {
        userRepositoryMock = null;
        userService = null;
    }


}
