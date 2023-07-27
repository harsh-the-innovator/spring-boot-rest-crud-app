package com.example.restcruddemo.dao;

import com.example.restcruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    // define field for EntityManager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // here below name of class Employee should come rather than your table name employee
        String queryString = "from Employee";
        TypedQuery<Employee> query = entityManager.createQuery(queryString, Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // if id == 0 then it will insert new employee else it will update
        Employee employeeToSave = entityManager.merge(employee);
        return employeeToSave;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
