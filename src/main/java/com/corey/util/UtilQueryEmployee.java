package com.corey.util;

public class UtilQueryEmployee {
    private UtilQueryEmployee() {
    }

    public static final String CREATE_TABLE_EMPLOYEE = "CREATE TABLE IF NOT EXISTS EMPLOYEE" +
            "(id INT NOT NULL AUTO_INCREMENT, " +
            "FIRSTNAME VARCHAR(30), " +
            "LASTNAME VARCHAR(30), " +
            "AGE INT NOT NULL, " +
            "EMAIL VARCHAR(30), " +
            "DATEOFCREATE DATE, " +
            "DEPARTMENTID INT NOT NULL, " +
            "PRIMARY KEY (ID))";
    public static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE " +
            "(FIRSTNAME, LASTNAME, AGE, EMAIL, DATEOFCREATE, DEPARTMENTID)" +
            " VALUES (?,?,?,?,?,?);";
    public static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEE SET " +
            "FIRSTNAME = ?, LASTNAME = ?, AGE = ?, EMAIL = ?, DEPARTMENTID = ? WHERE ID = ?;";
    public static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEE WHERE ID = ?;";
    public static final String SELECT_EMPLOYEE = "SELECT * FROM EMPLOYEE WHERE DEPARTMENTID = ?;";
    public static final String SELECT_ONE_EMPLOYEE = "SELECT * FROM EMPLOYEE WHERE ID = ?;";
    public static final String DROP_TABLE_EMPLOYEE = "DROP TABLE EMPLOYEE;";
}