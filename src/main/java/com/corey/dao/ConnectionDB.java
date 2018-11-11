package com.corey.dao;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
class ConnectionDB {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = " ";

    private ConnectionDB() {
    }

    //Connection DB
    static Connection getConnection() {
        Connection dbConnection = null;
        //Step 1 DRIVER
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        //Step 2 Opening the connection.
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASS);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return dbConnection;
    }
}