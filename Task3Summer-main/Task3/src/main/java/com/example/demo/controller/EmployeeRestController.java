package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    // Register
    @PostMapping("/register")
    public String register(@Valid @RequestBody User user) {

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return "Password and Confirm Password must match";
        }

        return userService.register(user);
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        loginService.validate(user.getUsername(), user.getPassword());

        return "Login Successful";
    }

    // Create Employee
    @PostMapping("/employee")
    public Employee create(@Valid @RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    // Display Employees
    @GetMapping("/employee")
    public List<Employee> display() {

        return employeeService.getAllEmployees();
    }

    // Raise Salary
    @PutMapping("/employee/{name}/{percentage}")
    public Employee raiseSalary(@PathVariable String name,
                                @PathVariable int percentage) {

        return employeeService.raiseSalary(name, percentage);
    }

}