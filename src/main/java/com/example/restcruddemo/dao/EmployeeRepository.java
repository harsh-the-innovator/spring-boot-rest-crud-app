package com.example.restcruddemo.dao;

import com.example.restcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// if we don't use RepositoryRestResource the default path will be /employees based on Entity name
@RepositoryRestResource(path = "members")   // the path will be /members
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // no need to write any code .
    // it automatically provides all basic crud methods so need of making dao
}
