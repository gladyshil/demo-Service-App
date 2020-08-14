package com.example.easynotes.controller;

import com.example.easynotes.controller.EmployeeController;
import com.example.easynotes.repository.EmployeeRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenEmployeeControllerInjected_thenNotNull() throws Exception{
        assertThat(employeeController).isNotNull();
    }

    /*@Test
    public void whenGetRequestToEmployees_thenCorrectResponse() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception{
        MediaType testPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String employee = "{\"name\":\"John Adams\", \"job\":\"Vice President\", \"salary\":\"300\", \"department\":\"politics\" }";
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .content(employee)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(testPlainUtf8));
    }

    @Test
    public void whenPostRequestToEmployeeAndInValidEmployee_thenCorrectResponse() throws Exception{
        String employee = "{\"name\":\"John Adams\", \"job\":\"Vice President\", \"salary\":\"300\", \"department\":\"politics\" }";
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
        .content(employee)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Is.is("Name is mandatory")))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        }*/
}