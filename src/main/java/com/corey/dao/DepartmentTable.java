package com.corey.dao;

import com.corey.model.Department;
import com.corey.util.UtilQueryDepartment;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public final class DepartmentTable {
    private DepartmentTable() {
    }

    //Creates a table in a database.
    public static synchronized int createTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryDepartment.CREATE_TABLE_DEPARTMENT)) {
            final int result = prStatement.executeUpdate();
            if (result == 0) {
                log.info("Created table");
                return 0;
            }
        } catch (SQLException e) {
            log.error("Error, the table is not created: {}", e.getMessage());
        }
        return -1;
    }

    //Insert table
    public static synchronized boolean insertIntoTable(Department department) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryDepartment.INSERT_DEPARTMENT)) {
            prStatement.setString(1, department.getName());
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
    public static synchronized int updateToTable(Department department) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryDepartment.UPDATE_DEPARTMENT)) {
            prStatement.setString(1, department.getName());
            prStatement.setLong(2, department.getId());
            // execute update SQL prepared statement
            log.info("Update");
            return prStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error update to table: {}", e.getMessage());
        }
        return 0;
    }

    //Delete record from table
    public static synchronized boolean deleteFromTable(Department department) {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryDepartment.DELETE_DEPARTMENT)) {
            prStatement.setLong(1, department.getId());
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
    public static synchronized List<Department> selectFromTable() {
        List<Department> departments = new ArrayList<>();
        try (final PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryDepartment.SELECT_DEPARTMENT);
             final ResultSet rs = prStatement.executeQuery()) {
            // execute select SQL prepared statement
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getLong("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
                log.info("select from table");
            }
        } catch (SQLException e) {
            log.error("Error select from table: {}", e.getMessage());
        }
        return departments;
    }

    public static synchronized Department selectOne(final long id) {
        try (PreparedStatement pr = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryDepartment.SELECT_ONE_DEPARTMENT)) {
            Department department = new Department();
            pr.setLong(1, id);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    department.setId(rs.getLong("id"));
                    department.setName(rs.getString("name"));
                }
                log.info("Select one department");
                return department;
            }
        } catch (SQLException e) {
            log.error("Error Select one department: {}", e.getMessage());
        }
        return null;
    }

    //Drop from table
    public static synchronized int dropTable() {
        try (PreparedStatement prStatement = ConnectionDB.getConnection()
                .prepareStatement(UtilQueryDepartment.DROP_TABLE_DEPARTMENT)) {
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