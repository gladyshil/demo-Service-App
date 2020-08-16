package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Employee;
import com.example.easynotes.repository.EmployeeRepository;
import com.example.easynotes.service.EmployeeService;
import com.example.easynotes.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // Get All Employees
    @RequestMapping(value="/employees")
    public ResponseEntity<Object> getEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }


    // Create a new Employee
    @RequestMapping (value="/employees", method=RequestMethod.POST)
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        List<Employee> employees = employeeService.getAllEmployees();
        for(int i = 0; i < employees.size(); i++){
            if((employees.get(i).getName()).equals(employee.getName())){
             return new ResponseEntity<>("Employee is a duplicate", HttpStatus.OK);
            }
        }
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
    }

    // Get a Single Employee
    @RequestMapping(value="/employees/{id}")
    public ResponseEntity<Object> getEmployeeById(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employee.getId()), HttpStatus.OK);
    }

    // Update an Employee
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {

        employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>("Employee is updated successfully", HttpStatus.OK);
    }


    // Delete an employee
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
    }

}