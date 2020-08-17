package com.example.easynotes.model;

import com.example.easynotes.Generator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Entity
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Employee implements Serializable {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(generator = Generator.generatorName)
    @GenericGenerator(name = Generator.generatorName, strategy = "com.example.easynotes.Generator")
    private int id;

    // @NotBlank
    private String first_name;

    // @NotBlank
    private String last_name;

    private String job;

    private String department;

    private Integer salary;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return first_name+" "+last_name;
    }

    public void setName(String name) {
        String[] splitStr = name.split("\\s+");
        this.first_name = splitStr[0];
        this.last_name = splitStr[1];
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }

    public void setSalary(Integer salary){
        this.salary = salary;
    }

    public Integer getSalary(){
        return salary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }




}