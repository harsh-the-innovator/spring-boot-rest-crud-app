package com.example.restcruddemo.dao;

import com.example.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
