package com.perrin.tony.managers;

import com.perrin.tony.models.User;
import com.perrin.tony.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserManagerTest {
    @Test
    public void shouldReturnInstanceOfUserManager() {
        UserManager userManager = new UserManager(null);
        Assert.assertNotNull(userManager);
    }

    @Test
    public void shouldReturnListOfUsers() {
        UserService userServiceMock = mock(UserService.class);
        when(userServiceMock.getAllUsers()).thenReturn(Arrays.asList(
                new User("Andrew", "Brown", 51),
                new User("Andrew", "Smith", 51),
                new User("Eric", "Briggs", 72),
                new User("Susan", "Briggs", 68)));
        UserManager userManager = new UserManager(userServiceMock);
        List<User> results = userManager.getAllUsers();
        Assert.assertNotNull(results);
        Assert.assertEquals(4, results.size());

        verify(userServiceMock, Mockito.times(1)).getAllUsers();
    }
}
