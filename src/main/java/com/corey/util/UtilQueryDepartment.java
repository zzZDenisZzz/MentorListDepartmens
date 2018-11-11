package com.corey.util;

public final class UtilQueryDepartment {
    private UtilQueryDepartment() {
    }

    public static final String CREATE_TABLE_DEPARTMENT = "CREATE TABLE IF NOT EXISTS DEPARTMENT" +
            "(ID INT NOT NULL AUTO_INCREMENT, " +
            "NAME VARCHAR(30), " +
            "PRIMARY KEY (ID))";
    public static final String INSERT_DEPARTMENT = "INSERT INTO DEPARTMENT (NAME) VALUES (?);";
    public static final String UPDATE_DEPARTMENT = "UPDATE DEPARTMENT SET NAME = ? WHERE ID = ?;";
    public static final String DELETE_DEPARTMENT = "DELETE FROM DEPARTMENT WHERE ID = ?;";
    public static final String SELECT_DEPARTMENT = "SELECT * FROM DEPARTMENT;";
    public static final String SELECT_ONE_DEPARTMENT = "SELECT * FROM DEPARTMENT WHERE ID = ?;";
    public static final String DROP_TABLE_DEPARTMENT = "DROP TABLE DEPARTMENT;";
}