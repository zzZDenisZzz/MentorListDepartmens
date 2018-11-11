package com.corey.dao;

import com.corey.model.Employee;
import com.corey.util.UtilQueryEmployee;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public final class EmployeeTable {
    private EmployeeTable() {
    }

    //Creates a table in a database.
    public static synchronized int createEmployeeTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryEmployee.CREATE_TABLE_EMPLOYEE)) {
            final int result = prStatement.executeUpdate();
            if (result == 0) {
                log.info("Created employee table");
                return 0;
            }
        } catch (SQLException e) {
            log.error("Error, the table is not created: {}", e.getMessage());
        }
        return -1;
    }

    //Insert table
    public static synchronized boolean insertTable(Employee employee) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryEmployee.INSERT_EMPLOYEE)) {
            prStatement.setString(1, employee.getFirstName());
            prStatement.setString(2, employee.getLastName());
            prStatement.setInt(3, employee.getAge());
            prStatement.setString(4, employee.getMail());
            java.util.Date date = new java.util.Date();
            prStatement.setDate(5, new Date(date.getTime()));
            prStatement.setLong(6, employee.getDepartmentId());
            // execute insert SQL prepared statement
            final int result = prStatement.executeUpdate();
            if (result > 0) {
                log.info("Department in table");
                return true;
            }
        } catch (SQLException e) {
            log.error("Error inserting into table: {}", e.getMessage());
        }
        return false;
    }

    //Update
    public static synchronized int updateTable(Employee employee) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryEmployee.UPDATE_EMPLOYEE)) {
            prStatement.setString(1, employee.getFirstName());
            prStatement.setString(2, employee.getLastName());
            prStatement.setInt(3, employee.getAge());
            prStatement.setString(4, employee.getMail());
            prStatement.setLong(5, employee.getDepartmentId());
            prStatement.setLong(6, employee.getId());
            // execute update SQL prepared statement
            log.info("Update");
            return prStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error update to table: {}", e.getMessage());
        }
        return 0;
    }

    //Delete record from table
    public static synchronized boolean deleteTable(Employee employee) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryEmployee.DELETE_EMPLOYEE)) {
            prStatement.setLong(1, employee.getId());
            // execute delete SQL prepared statement
            final int result = prStatement.executeUpdate();
            if (result == 0) {
                log.info("Delete");
                return true;
            }
        } catch (SQLException e) {
            log.error("Error delete from table: {}", e.getMessage());
        }
        return false;
    }

    //Select records from table
    public static synchronized List<Employee> selectEmployees(final long departmentId) {
        try (final PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryEmployee.SELECT_EMPLOYEE)) {
            // execute select SQL prepared statement
            List<Employee> employees = new ArrayList<>();
            prStatement.setLong(1,departmentId);
            try (final ResultSet rs = prStatement.executeQuery()) {
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getLong("ID"));
                    employee.setFirstName(rs.getString("FIRSTNAME"));
                    employee.setLastName(rs.getString("LASTNAME"));
                    employee.setAge(rs.getInt("AGE"));
                    employee.setMail(rs.getString("EMAIL"));
                    employee.setDepartmentId(rs.getLong("DEPARTMENTID"));
                    employees.add(employee);
                }
                log.info("select employees table");
                return employees;
            }
        } catch (SQLException e) {
            log.error("Error select from table: {}", e.getMessage());
        }
        return new ArrayList<>();
    }


    public static synchronized Employee selectOne(final long id) {
        try (PreparedStatement pr = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryEmployee.SELECT_ONE_EMPLOYEE)) {
            Employee employee = new Employee();
            pr.setLong(1, id);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    employee.setId(rs.getLong("ID"));
                    employee.setFirstName(rs.getString("FIRSTNAME"));
                    employee.setLastName(rs.getString("LASTNAME"));
                    employee.setAge(rs.getInt("AGE"));
                    employee.setMail(rs.getString("EMAIL"));
                    employee.setDateOfCreation(rs.getDate("DATEOFCREATION"));
                    employee.setDepartmentId(rs.getLong("DEPARTMENTID"));
                }
                log.info("Select one employee");
                return employee;
            }
        } catch (SQLException e) {
            log.error("Error Select one employee: {}", e.getMessage());
        }
        return null;
    }

    //Drop from table
    public static synchronized int dropEmployeeTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryEmployee.DROP_TABLE_EMPLOYEE)) {
            // execute delete SQL prepared statement
            final int result = prStatement.executeUpdate();
            if (result == 0) {
                log.info("Drop table");
                return 0;
            }
        } catch (SQLException e) {
            log.error("Drop error: {}", e.getMessage());
        }
        return -1;
    }
}