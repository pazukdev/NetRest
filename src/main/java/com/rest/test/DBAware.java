package com.rest.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAware {

    public static void main(String[] args) throws SQLException {

        final String selectAll = "SELECT * FROM users";

        DBProcessor db = new DBProcessor();
        Connection connection = db.getConnection(DBProcessor.URL, DBProcessor.USERNAME, DBProcessor.PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(selectAll);

        String data = "";
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            data += id + " " + name + "\n";
        }

        statement.close();
        connection.close();
        System.out.println(data);
    }
}