package com.utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConnectoin {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "matrix";
    private static final String DBName = "fsd_java";
    private Connection conn;
    public void DBConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL + DBName, USER, PASSWORD);
            System.out.println("Database connected successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public void DBClose(){
        try{
            conn.close();
            System.out.println("Database connection closed successfully");

        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
