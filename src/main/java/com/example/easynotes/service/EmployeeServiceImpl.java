package com.example.easynotes.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Department;
import com.example.easynotes.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.easynotes.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
    public boolean duplicateEmployee(List<Employee> employees, Employee employee){
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).equals(employee)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Employee createEmployee(Employee employee) { return employeeRepository.save(employee); }

    /*@Override
    public Employee createEmployee(Employee employee){
        List<Employee> employees = employeeRepository.findAll();
        Employee removed;
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).equals(employee)){
                removed = employees.get(i);
                employees.remove(removed);
            }
        }
        return employeeRepository.save(employee);
    }*/

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employeeDetails) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        employee.setName(employeeDetails.getName());
        employee.setJob(employeeDetails.getJob());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartment(employeeDetails.getDepartment());

        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    @Override
    public ResponseEntity<?> deleteEmployee(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }

}