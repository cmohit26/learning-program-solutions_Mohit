package com.cognizant.orm_learn_W3_Ex2.services;

import com.cognizant.orm_learn_W3_Ex2.model.Department;
import com.cognizant.orm_learn_W3_Ex2.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department get(int id) {
        LOGGER.info("Start");

        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new RuntimeException("Department with ID " + id + " not found");
        }

    }

    @Transactional
    public void save(Department department) {
        LOGGER.info("Start");
        departmentRepository.save(department);
        LOGGER.info("End");
    }
}
