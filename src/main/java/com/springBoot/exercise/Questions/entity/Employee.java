package com.springBoot.exercise.Questions.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Table(name = "Employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Employee_Name")
    @JsonProperty("Employee_Name")
    private String name;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public Employee() {
    }

    @Column(name = "Employee_Designation")
    @JsonProperty("Employee_Designation")
    private String designation;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
