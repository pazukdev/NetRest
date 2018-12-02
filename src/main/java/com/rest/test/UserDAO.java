package com.rest.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public String findAll() throws SQLException {
        List<User> listUsers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        final String sql = "SELECT * FROM users ORDER BY id";

        try {
            DBProcessor db = new DBProcessor();
            connection = db.getConnection(DBProcessor.URL, DBProcessor.USERNAME, DBProcessor.PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                listUsers.add(processRow(result));
            }
        } catch (SQLException e) {
            System.err.println("SQLException");
            return null;
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        String resultAsString="";
        for(User user : listUsers) {
            resultAsString += user.toString()+"<br>";
        }
        return resultAsString;
    }

    public String findByName(final String name) throws SQLException {
        List<User> listUsers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement=null;

        final String sql = "SELECT * FROM users WHERE(name) LIKE ? ORDER BY name";

        try {
            DBProcessor db = new DBProcessor();
            connection = db.getConnection(DBProcessor.URL, DBProcessor.USERNAME, DBProcessor.PASSWORD);

            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name.toUpperCase() + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listUsers.add(processRow(result));
            }
        } catch (SQLException e) {
            System.err.println("SQLException");
            return null;
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        String resultAsString="";
        for(User user : listUsers) {
            resultAsString += user.toString()+"<br>";
        }
        return resultAsString;
    }

    protected User processRow(final ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        return user;
    }

}