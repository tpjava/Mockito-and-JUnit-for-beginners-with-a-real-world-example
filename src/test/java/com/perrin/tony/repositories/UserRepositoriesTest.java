package com.perrin.tony.repositories;

import com.perrin.tony.BaseTest;
import com.perrin.tony.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserRepositoriesTest extends BaseTest {
    private static Connection connection;
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = new UserRepositoryImpl(connection);
    }


    @BeforeClass
    public static void setUpClass() throws SQLException {
        connection = getH2Connection();
        addTable(connection);
        insertData(connection);
    }

    @Test
    public void shouldReturnUserRepoImpl() {
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void shouldReturnAllUsers() {
        List<User> users = userRepository.getAllUsers();
        Assert.assertNotNull(users);
        Assert.assertEquals(8, users.size());
    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnAllUsersThenThrowSQLException() throws SQLException {
        Connection spy = spy(connection);
        when(spy.createStatement()).thenReturn(connection.createStatement()).thenThrow(SQLException.class);
        UserRepositoryImpl spyRepository = new UserRepositoryImpl(spy);
        List<User> users = spyRepository.getAllUsers();

        verify(spy, never()).getAutoCommit();
        Assert.assertNotNull(users);
        Assert.assertEquals(8, users.size());
        spyRepository.getAllUsers();
    }

    @Test(expected = RuntimeException.class)
    public void shouldTestSpy() throws SQLException {
        connection.createStatement();
        Connection spy = spy(connection);
        when(spy.createStatement()).thenThrow(new RuntimeException("Error calling method"));
        spy.createStatement();
    }

    @Test(expected = RuntimeException.class)
    public void shouldTestSpySecondCall() throws SQLException {
        Connection spy = spy(connection);
        when(spy.createStatement()).thenReturn(connection.createStatement()).thenThrow(new RuntimeException("Second call throws exception."));
        spy.createStatement();
        spy.createStatement();
    }


}
