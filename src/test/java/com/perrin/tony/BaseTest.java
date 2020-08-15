package com.perrin.tony;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTest {
    protected static void addTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS USERS "
                + "(id Integer AUTO_INCREMENT, "
                + "firstname VARCHAR(50), "
                + "lastname VARCHAR(50), "
                + "age Integer, "
                + "PRIMARY KEY (id))";
        statement.executeUpdate(sql);
    }

    protected static void insertData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO USERS "
                + "(firstname, lastname, age) "
                + "values "
                + "('Andrew', 'Brown', 55),"
                + "('Andrew', 'Smith', 31),"
                + "('Bob', 'Collins', 25),"
                + "('Mike', 'Mann', 67),"
                + "('Sarah', 'Smith', 29),"
                + "('Claire', 'Davies', 42),"
                + "('Eric', 'Briggs', 72),"
                + "('Sue', 'Briggs', 68)";
        statement.executeUpdate(sql);
    }

    protected static Connection getH2Connection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }

    protected static Connection getMYSQLConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
    }

    protected static void dropTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE USERS");
    }


}
