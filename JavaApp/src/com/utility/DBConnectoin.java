package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectoin {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "matrix";
    private static final String DBName = "fsd_java";
    private Connection conn;
    public Connection dbConnect(){
        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Step 2: Establish the connection
        try {
            conn = DriverManager.getConnection(URL + DBName, USER, PASSWORD);
            System.out.println("connection established at memory loc: " + conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public void DBClose(){
        try{
            conn.close();
            System.out.println("Database connection closed successfully");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
