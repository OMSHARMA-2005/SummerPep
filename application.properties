package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(
        regexp = "^[A-Za-z]+(\\s[A-Za-z]+){0,2}$",
        message = "Name should contain only alphabets and maximum 3 words"
    )
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must not exceed 60")
    private int age;

    private String designation;

    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}