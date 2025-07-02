package com.cognizant.orm_learn_W3_Ex2.repository;

import com.cognizant.orm_learn_W3_Ex2.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
