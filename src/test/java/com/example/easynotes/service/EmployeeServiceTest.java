package com.example.easynotes.service;

import com.example.easynotes.ProjectApplicationTests;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Employee;
import com.example.easynotes.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;

import static org.mockito.ArgumentMatchers.any;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;


//@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = ProjectApplicationTests.class)
@Transactional
public class EmployeeServiceTest {

   // @Mock
   // private EmployeeRepository employeeRepositoryMock;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository newEmployeeRepository;

    //private Employee employee = new Employee();

    @Before
    public void setup(){
      // employeeRepositoryMock = Mockito.mock(EmployeeRepository.class);
       // employeeService = new EmployeeServiceImpl();

        //employee.setId(1);
        //employee.setName("Andrew Jacob");
        //employee.setDepartment("Shoes");
        //employee.setSalary(32);
        //employee.setJob("Shoe clerk");

       // employeeRepositoryMock.save(Mockito.any(Employee.class));
    }

    @Test
    public void whenGetAll_thenReturnEmployeeList() {

      //  List<Employee> expectedEmployees = Arrays.asList(employee);
        //doReturn(expectedEmployees).when(newEmployeeRepository).findAll();
        //List<Employee> actualEmployees = employeeService.getAllEmployees();
       // assertThat(actualEmployees).isEqualTo(expectedEmployees);
      List<Employee> employees = newEmployeeRepository.findAll();
       // List<Employee> employees = employeeService.getAllEmployees();
       assertNotNull(employees);

    }

   /* @Test
    public void whenGetById_thenReturnEmployee(){
        //given
        final Integer id = 1;

        //doReturn(Optional.of(employee)).when(employeeRepository.findById(id));
        when(employeeRepositoryMock.findById(id)).thenReturn(Optional.of(employee));
        final Employee expectedEmployee = employeeService.getEmployeeById(id);

        assertThat(expectedEmployee).isEqualTo(employee);
    }*/

  /*  @Test
    public void createEmployeeSuccessfully() throws Exception {
        when(employeeRepositoryMock.findById(eq(1L))).thenReturn(Optional.empty());
        doAnswer(returnsFirstArg()).when(employeeRepositoryMock).save(any(Employee.class));
        Employee employeeNew = employeeService.createEmployee(employee);
        assertEquals(employee.getName(), employeeNew.getName());
        assertNotNull(employeeNew.getId());
    }*/

   /*@Test
    public void testUpdateEmployee(){
        final Integer id = 1;

        when(employeeRepositoryMock.save(Mockito.any(Employee.class))).thenReturn(employee);

        final Employee expectedEmployee = employeeService.updateEmployee(id, employee);

        assertThat(expectedEmployee).isNotNull();
        verify(employeeRepositoryMock).save(any(Employee.class));

    }

    @Test
    public void testDeleteEmployee(){
        final Integer employeeId = 1;


        employeeService.deleteEmployee(employeeId);
        employeeService.deleteEmployee(employeeId);

        verify(employeeRepositoryMock, times(2)).deleteById(employeeId);
    }*/
}