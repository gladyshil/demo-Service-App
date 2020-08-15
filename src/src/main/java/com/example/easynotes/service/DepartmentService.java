package com.example.easynotes.service;

import com.example.easynotes.model.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DepartmentService {
    public abstract List<Department> getAllDepartments();
    public abstract Department createDepartment(@RequestBody Department department);
    public abstract Department getDepartmentById(@PathVariable(value = "id") Long departmentId);
    public abstract Department updateDepartment(@PathVariable(value = "id") Long employeeId, @RequestBody Department departmentDetails);
    public abstract ResponseEntity<?> deleteDepartment(@PathVariable(value = "id") Long departmentId);
}