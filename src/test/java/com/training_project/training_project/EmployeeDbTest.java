package com.training_project.training_project;

import com.training_project.training_project.model.Department;
import com.training_project.training_project.model.Employee;
import com.training_project.training_project.service.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDbTest {
    @Autowired
    EmployeeRepository empRepo;

    @Test
    @Order(1)
    public void insertEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployeeName("Vikrant");
        employee.setEmployeeEmail("vikrant@gmail.com");
        employee.setEmployeeAge(22);
        employee.setDepartment(new Department(1,""));

        empRepo.save(employee);
        Assertions.assertTrue(empRepo.existsById(1));
    }

    @Test
    @Order(2)
    public void getAllEmployeesTest() {
        List<Employee> employeeList = empRepo.findAll();
        Assertions.assertFalse(employeeList.isEmpty());
    }

    @Test
    @Order(3)
    public void getEmployeeByIdTest() {
        Assertions.assertNotNull(empRepo.findById(1).get());
    }

    @Test
    @Order(4)
    public void updateEmployeeTest() {
        Employee employee = empRepo.findById(1).get();
        employee.setEmployeeName("Ajay");
        employee.setEmployeeEmail("ajay@gmail.com");
        employee.setEmployeeAge(21);

        empRepo.save(employee);

        Assertions.assertEquals("Ajay", empRepo.findById(1).get().getEmployeeName());
    }

    @Test
    @Order(5)
    public void deleteEmployeeTest() {
        empRepo.deleteById(1);
        Assertions.assertFalse(empRepo.existsById(1));
    }

}
