package com.example.easynotes;

import com.example.easynotes.model.Employee;
import com.example.easynotes.repository.EmployeeRepository;
import com.example.easynotes.service.EmployeeService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseConnectionTest{

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    @Ignore
    public void setup(){
//        employeeRepository = Mockito.mock(EmployeeRepository.class);
//        employeeService = Mockito.mock(EmployeeService.class);
    }

    @Test
    public void connectionTest(){
        List<Employee> employees = employeeRepository.findAll();
        assertNotNull(employees);

    }

    @Test
    public void testGetAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        doReturn(employees).when(employeeRepository).findAll();
        assertNotNull(employees);
    }

    @Test
    @Ignore
    public void testGetById(){
        Integer id = 1;
        Employee employee = employeeService.getEmployeeById(id);
       // Optional<Employee> employee = employeeRepository.findById(id);
       // doReturn(Optional.of(employee)).when(employeeRepository.findById(id));
        when(employeeService.getEmployeeById(id)).thenReturn(employee);
        //assertNotNull(employee);

    }
    @Test
    @Ignore
    public void createEmployeeSuccessfully() {
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("Andrew Jacob");
        employee.setDepartment("Shoes");
        employee.setSalary(32);
        employee.setJob("Shoe clerk");
        //doAnswer(returnsFirstArg()).when(employeeService.createEmployee(employee));
        when(employeeService.createEmployee(employee)).thenReturn(employee);
        assertNotNull(employee.getId());
    }
    @Test
    @Ignore
    public void testUpdateEmployee(){

        final Integer id = 5;
        Employee employee = new Employee();
        employee.setId(5);
        employee.setName("Andrew Jacob");
        employee.setDepartment("Women's Shoes");
        employee.setSalary(32);
        employee.setJob("Shoe clerk");
        employeeService.createEmployee(employee);
        when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
        employee.setDepartment("Men's Shoes");
        final Employee expectedEmployee = employeeService.updateEmployee(1, employee);
        assertThat(expectedEmployee).isNotNull();
        //verify(employeeRepository).save(Mockito.any(Employee.class));

    }




}