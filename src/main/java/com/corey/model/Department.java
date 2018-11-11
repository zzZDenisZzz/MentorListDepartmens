package com.corey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long id;
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department(Long id) {
        this.id = id;
    }
}