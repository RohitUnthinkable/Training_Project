package com.training_project.training_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@JsonIgnoreProperties(value = {"employees"})
public class Department extends Auditable {
    @Id
    private int id;

    @Column(name = "department_name")
    private String departmentName;

    public Department() {
    }

    public Department(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
