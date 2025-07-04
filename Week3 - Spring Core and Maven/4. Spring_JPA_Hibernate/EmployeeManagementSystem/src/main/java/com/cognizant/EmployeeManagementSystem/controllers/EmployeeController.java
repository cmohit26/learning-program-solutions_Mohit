package com.cognizant.EmployeeManagementSystem.controllers;


import com.cognizant.EmployeeManagementSystem.entities.Department;
import com.cognizant.EmployeeManagementSystem.entities.Employee;
import com.cognizant.EmployeeManagementSystem.repository.DepartmentRepository;
import com.cognizant.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Employee> searchByName(@RequestParam String keyword) {
        System.out.println("Searching for: " + keyword);
        List<Employee> employees = employeeRepository.searchByName(keyword);
        System.out.println("Found: " + employees.size() + " employees.");
        return employees;
    }

    @GetMapping("/search")
    private Page<Employee> searchByName(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = (Pageable) PageRequest.of(page, size, sort);
        return employeeRepository.searchByName(keyword, pageable);
    }


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        if (employee.getDepartment() != null) {
            Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
            employee.setDepartment(dept);
        }
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmp) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmp.getName());
                    employee.setEmail(updatedEmp.getEmail());
                    if (updatedEmp.getDepartment() != null) {
                        Department dept = departmentRepository.findById(updatedEmp.getDepartment().getId()).orElse(null);
                        employee.setDepartment(dept);
                    }
                    return ResponseEntity.ok(employeeRepository.save(employee));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
