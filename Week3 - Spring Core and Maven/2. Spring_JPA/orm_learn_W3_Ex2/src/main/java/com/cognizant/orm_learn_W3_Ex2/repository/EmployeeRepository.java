package com.cognizant.orm_learn_W3_Ex2.repository;

import com.cognizant.orm_learn_W3_Ex2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
