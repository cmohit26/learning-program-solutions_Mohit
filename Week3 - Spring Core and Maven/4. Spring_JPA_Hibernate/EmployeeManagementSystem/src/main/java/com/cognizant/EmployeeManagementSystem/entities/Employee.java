package com.cognizant.EmployeeManagementSystem.entities;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

import jakarta.persistence.*;
import lombok.*;

@NamedQueries({
        @NamedQuery(
                name = "Employee.findByEmailNamed",
                query = "SELECT e FROM Employee e WHERE e.email = :email"
        ),
        @NamedQuery(
                name = "Employee.findAllEngineering",
                query = "SELECT e FROM Employee e WHERE e.department.name = 'Engineering'"
        )
})

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
