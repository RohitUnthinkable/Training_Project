package com.training_project.training_project.controller;

import com.training_project.training_project.custom_exception.DepartmentNotFoundException;
import com.training_project.training_project.model.Department;
import com.training_project.training_project.service.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentRepository deptRepo;

    @GetMapping(path = "/departments")
    public List<Department> getAllDepartments() {
        return deptRepo.findAll();
    }

    @GetMapping(path = "/departments/{deptId}")
    public Department getDepartmentById(@PathVariable int deptId) {
        if(!deptRepo.existsById(deptId)) {
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return deptRepo.findById(deptId).get();
    }

    @PostMapping(path = "/departments")
    public void addDepartment(@RequestBody Department department) {
        deptRepo.save(department);
    }

    @DeleteMapping(path = "/departments/{deptId}")
    public void removeDepartment(@PathVariable int deptId) {
        if(!deptRepo.existsById(deptId)) {
            throw new DepartmentNotFoundException("Department Not Found");
        }else {
            deptRepo.deleteById(deptId);
        }
    }

    @PutMapping(path = "/departments")
    public void updateDepartment(@RequestBody Department department) {
        if(!deptRepo.existsById(department.getId())) {
            throw new DepartmentNotFoundException("Department Not Found");
        }else {
            deptRepo.save(department);
        }
    }
}
