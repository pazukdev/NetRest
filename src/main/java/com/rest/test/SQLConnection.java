package com.rest.test;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SQLConnection {

    private InitialContext ic;
    private DataSource ds;

    public Connection getConnection() throws SQLException, NamingException	{
        ic = new InitialContext();
        ds = (DataSource) ic.lookup("java:/comp/env/jdbc/mydbtest");
        return ds.getConnection();
    }

}