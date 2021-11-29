package com.training_project.training_project.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "employee")
public class Employee extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "employee_name")
    private String employeeName;

    @Email
    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_age")
    private int employeeAge;

    @ManyToOne(optional = false)
    private Department department;

    public Employee() {
    }

    public Employee(String employeeName, String employeeEmail, int employeeAge) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeAge = employeeAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeAge=" + employeeAge +
                ", department="+ department+
                '}';
    }
}