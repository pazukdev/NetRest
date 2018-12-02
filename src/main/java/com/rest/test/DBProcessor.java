package com.rest.test;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProcessor {

    static final String URL = "jdbc:mysql://localhost:3306"
            + "/mydbtest?useSSL=true&amp;autoReconnect=true&amp;serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    private Connection connection;

    DBProcessor() throws SQLException {
        DriverManager.registerDriver(new FabricMySQLDriver());
    }

    Connection getConnection(final String url,
                             final String username,
                             final String password) throws SQLException {
        if (connection == null) {
            return connection = DriverManager.getConnection(url, username, password);
        } else return connection;
    }
}
