package com.main;

import com.utility.DBConnectoin;

public class Main {
    public static void main(String[] args) {
        DBConnectoin dbConnection = new DBConnectoin();
        dbConnection.DBConnect();
        dbConnection.DBClose();
    }
}