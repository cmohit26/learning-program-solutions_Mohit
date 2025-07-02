package com.cognizant.orm_learn_W3_Ex2;

import com.cognizant.orm_learn_W3_Ex2.model.Department;
import com.cognizant.orm_learn_W3_Ex2.model.Employee;
import com.cognizant.orm_learn_W3_Ex2.model.Skill;
import com.cognizant.orm_learn_W3_Ex2.services.DepartmentService;
import com.cognizant.orm_learn_W3_Ex2.services.EmployeeService;
import com.cognizant.orm_learn_W3_Ex2.services.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OrmLearnW3Ex2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnW3Ex2Application.class, args);

		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		System.out.println("------------------------------------------------------------------------------");
//		testAddEmployee();
//		testGetEmployee();
//		testUpdateEmployee();
		System.out.println("------------------------------------------------------------------------------");
//		testGetDepartment();
		System.out.println("------------------------------------------------------------------------------");
		testAddSkillToEmployee();
		System.out.println("------------------------------------------------------------------------------");
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);

	@Autowired
	private static EmployeeService employeeService;

	@Autowired
	private static DepartmentService departmentService;

	@Autowired
	private static SkillService skillService;

	@Autowired
	public void setEmployeeService(EmployeeService service) {
		employeeService = service;
	}

	@Autowired
	public void setDepartmentService(DepartmentService service) {
		departmentService = service;
	}

	@Autowired
	public void setSkillService(SkillService service) {
		skillService = service;
	}

	private static void testGetDepartment() {
		LOGGER.info("Start");

		Department department = departmentService.get(1); // Use a valid department ID
		LOGGER.debug("Department: {}", department);
		LOGGER.debug("Employees: {}", department.getEmployeeList());

		LOGGER.info("End");
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee: {}", employee);
		LOGGER.debug("Department: {}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {
		LOGGER.info("Start");
		Employee employee = new Employee();
		employee.setName("Test Employee");
		employee.setSalary(60000.0);
		employee.setPermanent(true);
		employee.setDateOfBirth(java.sql.Date.valueOf("1990-01-01"));

		Department department = departmentService.get(1); // assuming dept with id 1 exists
		employee.setDepartment(department);

		employeeService.save(employee);
		LOGGER.debug("Saved Employee: {}", employee);
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Department newDept = departmentService.get(2); // switch to different department
		employee.setDepartment(newDept);

		employeeService.save(employee);
		LOGGER.debug("Updated Employee: {}", employee);
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");

		// Get Employee and Skill by ID
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(2); // choose a skill ID that’s not already linked

		// Add skill to employee
		Set<Skill> skills = employee.getSkillList();
		if (skills == null) {
			skills = new HashSet<>();
		}
		skills.add(skill);
		employee.setSkillList(skills);

		// Save employee
		employeeService.save(employee);

		LOGGER.debug("Updated Employee Skills: {}", employee.getSkillList());
		LOGGER.info("End");
	}



}
