package com.example.restcruddemo.controller;

import com.example.restcruddemo.entity.Employee;
import com.example.restcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    /**
     * API for getting employee by id
     *
     * @param id id of employee
     * @return employee
     * @Method GET
     */
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee id not found: " + id);
        }

        return employee;
    }

    /**
     * API for creating a new employee
     *
     * @return employee
     * @Method POST
     * @RequestBody employee
     */
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        // also just in case they pass an id in json - set id to 0
        // this is a force to save a new item instead of update

        employee.setId(0);

        Employee employeeToSave = employeeService.save(employee);

        return employeeToSave;
    }

    /**
     * API for updating an employee
     *
     * @return employee
     * @Method PUT
     * @RequestBody employee
     */
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employeeToSave = employeeService.save(employee);

        return employeeToSave;
    }

    /**
     * API for deleting an employee by id
     *
     * @param id id of employee to delete
     * @return deleted id
     * @Method DELETE
     */
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee temp = employeeService.findById(id);

        // if there is no employee with id
        if (temp == null) {
            throw new RuntimeException("Employee id not found: " + id);
        }

        // else delete employee
        employeeService.deleteById(id);

        return "Deleted employee id: " + id;
    }
}
