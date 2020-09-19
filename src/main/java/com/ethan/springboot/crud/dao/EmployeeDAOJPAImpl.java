package com.ethan.springboot.crud.dao;

import com.ethan.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query theQuery = entityManager.createQuery("from Employee");

        return (List<Employee>) theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public void save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}
