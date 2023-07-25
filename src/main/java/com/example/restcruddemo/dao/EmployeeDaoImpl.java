package com.example.restcruddemo.dao;

import com.example.restcruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

    // define field for EntityManager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        String queryString = "from employee";
        TypedQuery<Employee> query = entityManager.createQuery(queryString,Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }
}
