package com.example.easynotes.service;

import java.util.Collection;
import java.util.List;

import com.example.easynotes.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeService {
    public abstract List<Employee> getAllEmployees();
    public abstract Employee createEmployee(@RequestBody Employee employee);
    public abstract Employee getEmployeeById(@PathVariable(value = "id") Integer employeeId);
    public abstract Employee updateEmployee(@PathVariable(value = "id") Integer employeeId, @RequestBody Employee employeeDetails);
    public abstract ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Integer employeeId);
}