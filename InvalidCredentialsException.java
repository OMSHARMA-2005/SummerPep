package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/create")
    public Object createEmployee(@Valid @RequestBody Employee employee,
                                 BindingResult result) {

        if (result.hasErrors()) {
            return result.getAllErrors();
        }

        return service.saveEmployee(employee);
    }

    @GetMapping("/display")
    public List<Employee> displayEmployees() {
        return service.getAllEmployees();
    }

    @PutMapping("/raise/{name}/{percentage}")
    public Employee raiseSalary(@PathVariable String name,
                                @PathVariable int percentage) {
        return service.raiseSalary(name, percentage);
    }
}