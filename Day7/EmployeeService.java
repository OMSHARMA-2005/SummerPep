package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private EmployeeService service;

    // ==========================
    // Create Employee Page
    // ==========================
    @GetMapping("/createPage")
    public String createPage(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        model.addAttribute("employee", new Employee());
        model.addAttribute("username", session.getAttribute("user"));

        return "create";
    }

    // ==========================
    // Save Employee
    // ==========================
    @PostMapping("/save")
    public String saveEmployee(@Valid Employee employee,
                               BindingResult result,
                               HttpSession session,
                               Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            model.addAttribute("username", session.getAttribute("user"));
            return "create";
        }

        service.saveEmployee(employee);

        model.addAttribute("username", session.getAttribute("user"));

        return "createSuccess";
    }

    // ==========================
    // Display Employees
    // ==========================
    @GetMapping("/displayPage")
    public String displayEmployees(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        List<Employee> employees = service.getAllEmployees();

        model.addAttribute("employees", employees);
        model.addAttribute("username", session.getAttribute("user"));

        return "display";
    }

    // ==========================
    // Raise Salary Page
    // ==========================
    @GetMapping("/raisePage")
    public String raisePage(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        model.addAttribute("username", session.getAttribute("user"));

        return "raiseSalary";
    }

    // ==========================
    // Raise Salary
    // ==========================
    @PostMapping("/raiseSalary")
    public String raiseSalary(@RequestParam String name,
                              @RequestParam int percentage,
                              HttpSession session,
                              Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (percentage < 1 || percentage > 10) {

            model.addAttribute("error", "Percentage must be between 1 and 10");
            model.addAttribute("username", session.getAttribute("user"));

            return "raiseSalary";
        }

        Employee employee = service.raiseSalary(name, percentage);

        if (employee == null) {

            model.addAttribute("error", "Employee not found");
            model.addAttribute("username", session.getAttribute("user"));

            return "raiseSalary";
        }

        model.addAttribute("employee", employee);
        model.addAttribute("username", session.getAttribute("user"));

        return "raiseSuccess";
    }

    // ==========================
    // Exit Page
    // ==========================
    @GetMapping("/exit")
    public String exit(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        model.addAttribute("username", session.getAttribute("user"));

        return "exit";
    }

}