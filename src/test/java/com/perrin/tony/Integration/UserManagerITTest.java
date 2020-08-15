package com.perrin.tony.Integration;

import com.perrin.tony.BaseTest;
import com.perrin.tony.managers.UserManager;
import com.perrin.tony.models.User;
import com.perrin.tony.repositories.UserRepositoryImpl;
import com.perrin.tony.services.UserServiceImpl;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserManagerITTest extends BaseTest {
    private static Connection connection;

    @BeforeClass
    public static void setUpClass() throws SQLException {
        connection = getH2Connection();
        addTable(connection);
        insertData(connection);
    }

    @Test
    public void shouldReturnTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldReturnAnInstanceOfAUserManager() {
        UserManager userManager = new UserManager(null);
        Assert.assertNotNull(userManager);
    }

    @Test
    public void shouldReturnListOFAllUsersWhenGetAllUsersCalled() {
        UserManager userManager = new UserManager(new UserServiceImpl(new UserRepositoryImpl(connection)));
        List<User> results = userManager.getAllUsers();
        Assert.assertFalse(results.isEmpty());
        Assert.assertEquals(8, results.size());
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        dropTable(connection);
    }

}
