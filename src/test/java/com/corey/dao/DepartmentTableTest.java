package com.corey.dao;

import com.corey.model.Department;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTableTest {
    private Department department = new Department(1L,"dep1");
    private Department department2 = new Department(1L,"dep122");

    @Test
    public void createTable() {
        int create = DepartmentTable.createTable();
        assertEquals(0, create);
    }

    @Test
    public void insertIntoTable() {
        assertTrue(DepartmentTable.insertIntoTable(department));
    }

    @Test
    public void updateToTable() {
        assertEquals(0, DepartmentTable.updateToTable(department));
    }

    @Test
    public void deleteFromTable() {
        assertTrue(DepartmentTable.deleteFromTable(department2));
    }

    @Test
    public void dropTable() {
        int result = DepartmentTable.dropTable();
        assertEquals(0, result);
    }
}