package com.corey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String mail;
    private Date dateOfCreation;
    private Long departmentId;

    public Employee(String firstName, String lastName, int age, String mail, Long departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
        this.departmentId = departmentId;
    }
}