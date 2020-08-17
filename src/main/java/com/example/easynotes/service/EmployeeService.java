package com.example.easynotes.service;

import java.util.Collection;
import java.util.List;

import com.example.easynotes.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface EmployeeService {
    public abstract List<Employee> getAllEmployees();
    public abstract Employee createEmployee(@RequestBody Employee employee);
    public abstract Employee getEmployeeById(@PathVariable(value = "id") int employeeId);
    public abstract Employee updateEmployee(@PathVariable(value = "id") int employeeId, @RequestBody Employee employeeDetails);
    public abstract ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") int employeeId);
}