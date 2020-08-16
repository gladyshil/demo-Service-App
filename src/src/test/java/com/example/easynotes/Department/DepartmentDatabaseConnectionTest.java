package com.example.easynotes.Department;

import com.example.easynotes.model.Department;
import com.example.easynotes.repository.DepartmentRepository;
import com.example.easynotes.service.DepartmentService;
import com.example.easynotes.service.EmployeeService;
import org.junit.Before;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = "spring.profiles.active=test")
public class DepartmentDatabaseConnectionTest{

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Before
    public void setup(){
        departmentRepository = Mockito.mock(DepartmentRepository.class);
        departmentService = Mockito.mock(DepartmentService.class);
    }

    @Test
    public void connectionTest(){
        List<Department> departments = departmentRepository.findAll();
        assertNotNull(departments);

    }

    @Test
    public void testGetAllEmployees(){
        List<Department> departments = departmentService.getAllDepartments();
        doReturn(departments).when(departmentRepository).findAll();
        assertNotNull(departments);
    }

    @Test
    public void testGetById(){
        Integer id = 1;
        Department department = departmentService.getDepartmentById(id);
        // Optional<Employee> employee = employeeRepository.findById(id);
        // doReturn(Optional.of(employee)).when(employeeRepository.findById(id));
        when(departmentService.getDepartmentById(id)).thenReturn(department);
        //assertNotNull(employee);

    }
    @Test
    public void createEmployeeSuccessfully() {
        Department department = new Department();
        department.setId(4);
        department.setDepartmentName("Women's Shoes");
        department.setLocation("West Side");
        department.setDepartmentManager("Chris Wong");

        //doAnswer(returnsFirstArg()).when(employeeService.createEmployee(employee));
        when(departmentService.createDepartment(department)).thenReturn(department);
        assertNotNull(department.getId());
    }
    @Test
    public void testUpdateEmployee(){

        final Integer id = 5;
        Department department = new Department();
        department.setId(4);
        department.setDepartmentName("Women's Shoes");
        department.setLocation("West Side");
        department.setDepartmentManager("Chris Wong");
        departmentService.createDepartment(department);
        when(departmentRepository.save(Mockito.any(Department.class))).thenReturn(department);
        department.setLocation("East side");
        final Department expectedDepartment = departmentService.updateDepartment(1, department);
        assertThat(expectedDepartment).isNotNull();
        //verify(employeeRepository).save(Mockito.any(Employee.class));

    }




}