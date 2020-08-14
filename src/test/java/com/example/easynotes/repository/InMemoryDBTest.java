package com.example.easynotes.repository;

import com.example.easynotes.model.Employee;
import com.example.easynotes.service.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DirtiesContext
public class InMemoryDBTest {

    @Resource
    private EmployeeRepository employeeRepository;
    private static final Integer ID = 1;
    private static final String NAME = "John Adams";


    @Test
    public void givenEmployeeId_whenSave_thenGetOk() {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Adams");
        employee.setJob("Vice President");
        employee.setSalary(300);
        employee.setDepartment("Politics");

        employeeRepository.save(employee);


        Employee employee2 = employeeRepository.findById(ID).get();
        assertEquals("name incorrect", NAME, employee2.getName());
    }
}