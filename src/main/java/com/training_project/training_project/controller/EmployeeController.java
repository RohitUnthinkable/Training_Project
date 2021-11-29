package com.training_project.training_project.controller;

import com.training_project.training_project.custom_exception.DepartmentNotFoundException;
import com.training_project.training_project.custom_exception.EmployeeNotFoundException;
import com.training_project.training_project.model.Department;
import com.training_project.training_project.model.Employee;
import com.training_project.training_project.service.DepartmentRepository;
import com.training_project.training_project.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    DepartmentRepository deptRepo;

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @GetMapping(path = "/employees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId) {
        if(!empRepo.existsById(empId)) {
            //employee id not found
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return empRepo.findById(empId).get();
    }

    @PostMapping(path = "/employees/{deptId}")
    public void addEmployee(@Valid @RequestBody Employee employee, @PathVariable int deptId) {
        if(!deptRepo.existsById(deptId)) {
            //department id not found
            throw new DepartmentNotFoundException("Department Not Found");
        }else {
            employee.setDepartment(new Department(deptId,""));// spring automatically fetch the details of department using department Id and add it in the department object that we pass.
            empRepo.save(employee);
        }
    }

    @DeleteMapping(path = "/employees/{empId}")
    public void removeEmployee(@PathVariable int empId) {
        if(!empRepo.existsById(empId)) {
            //employee id not found
            throw new EmployeeNotFoundException("Employee Not Found");
        }else {
            empRepo.deleteById(empId);
        }
    }

    @PutMapping(path = "/employees/{empId}/departments/{deptId}")
    public void updateEmployee(@Valid @RequestBody Employee employee, @PathVariable int empId ,@PathVariable int deptId) {
        if(!empRepo.existsById(empId)){
            throw new EmployeeNotFoundException("Employee Not Found");
        }else {
            if(!deptRepo.existsById(deptId)) {
                throw new DepartmentNotFoundException("Department Not Found");
            }else {
                employee.setId(empId);
                employee.setDepartment(new Department(deptId, ""));
                empRepo.save(employee);
            }
        }
    }
}
