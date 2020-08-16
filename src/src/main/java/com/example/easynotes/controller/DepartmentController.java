package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Department;
import com.example.easynotes.repository.EmployeeRepository;
import com.example.easynotes.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    // Get All Employees
    @RequestMapping(value="/departments")
    public ResponseEntity<Object> getDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    // Create a new Employee
    @RequestMapping (value="/departments", method=RequestMethod.POST)
    public ResponseEntity<Object> createDepartments(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>("Department is created successfully", HttpStatus.CREATED);
    }

    // Get a Single Employee
    @RequestMapping(value="/departments/{id}")
    public ResponseEntity<Object> getDepartmentById(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.getDepartmentById(department.getId()), HttpStatus.OK);
    }

    // Update an Employee
    @RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateEmployee(@PathVariable("id") int id, @RequestBody Department department) {

        departmentService.updateDepartment(id, department);
        return new ResponseEntity<>("Employee is updated successfully", HttpStatus.OK);
    }


    // Delete an employee
    @RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
    }

}