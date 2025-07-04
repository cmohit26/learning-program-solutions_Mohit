package com.cognizant.EmployeeManagementSystem.repository;

import com.cognizant.EmployeeManagementSystem.entities.Department;
import com.cognizant.EmployeeManagementSystem.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> searchByName(@Param("keyword") String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findEmployeesByDepartmentName(@Param("deptName") String deptName);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Employee> searchByName(@Param("keyword") String keyword, Pageable pageable);

    @Query(name = "Employee.findByEmailNamed")
    Employee getByEmailNamed(@Param("email") String email);

    List<Employee> findByName(String name);                      // Exact match

    List<Employee> findByNameContaining(String keyword);         // Like '%keyword%'

    List<Employee> findByDepartment(Department department);      // By department entity

    List<Employee> findByDepartmentId(Long deptId);              // By department id

    Employee findByEmail(String email);                          // Unique email
}