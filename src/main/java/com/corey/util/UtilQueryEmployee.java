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
    public static final String INSERT_DEPARTAMENT = "INSERT INTO EMPLOYEE (name) VALUES (?);";
    public static final String UPDATE_DEPARTAMENT = "UPDATE EMPLOYEE SET name = ? WHERE id = ?;";
    public static final String DELETE_DEPARTAMENT = "DELETE FROM EMPLOYEE WHERE id = ?;";
    public static final String SELECT_DEPARTAMENT = "SELECT * FROM EMPLOYEE;";
    public static final String SELECT_ONE_DEPARTAMENT = "SELECT * FROM EMPLOYEE WHERE id = ?;";
    public static final String DROP_TABLE_DEPARTAMENT = "DROP TABLE EMPLOYEE;";
}