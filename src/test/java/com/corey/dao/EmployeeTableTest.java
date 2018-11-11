package com.corey.dao;

import com.corey.model.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeTableTest {
    private Employee employee = new Employee("Corey", "Taylor", 40, "corey666@ukr.net",1L);
    private Employee employee2 = new Employee("Denys", "Zazeka", 27, "corey2007@bigmir.net",1L);

    @Test
    public void createTable() {
        int create = EmployeeTable.createEmployeeTable();
        assertEquals(0, create);
    }

    @Test
    public void insertIntoTable() {
        assertTrue(EmployeeTable.insertTable(employee));
    }

    @Test
    public void updateToTable() {
        assertEquals(0, EmployeeTable.updateTable(employee));
    }

    @Test
    public void deleteFromTable() {
        assertTrue(EmployeeTable.deleteTable(employee2));
    }

    @Test
    public void dropTable() {
        int result = EmployeeTable.dropEmployeeTable();
        assertEquals(0, result);
    }
}