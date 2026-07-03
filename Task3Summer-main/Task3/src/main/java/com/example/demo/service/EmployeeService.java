package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

   
    public Employee saveEmployee(Employee employee) {

        if (employee.getDesignation().equalsIgnoreCase("Programmer")) {
            employee.setSalary(25000);
        } 
        else if (employee.getDesignation().equalsIgnoreCase("Tester")) {
            employee.setSalary(20000);
        } 
        else if (employee.getDesignation().equalsIgnoreCase("Manager")) {
            employee.setSalary(300000);
        }

        return repository.save(employee);
    }

    // Display All Employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Raise Salary
    public Employee raiseSalary(String name, int percentage) {

        Optional<Employee> optional = repository.findByName(name);

        if (optional.isPresent()) {

            Employee employee = optional.get();

            double salary = employee.getSalary();

            salary = salary + (salary * percentage / 100.0);

            employee.setSalary(salary);

            return repository.save(employee);
        }

        return null;
    }
}