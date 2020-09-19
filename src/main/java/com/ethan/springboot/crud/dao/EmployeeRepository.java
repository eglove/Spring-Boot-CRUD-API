package com.ethan.springboot.crud.dao;

import com.ethan.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Default path for API is Entity name lowercase with s on end. (Employee = employees)
/*@RepositoryRestResource(path="members")*/
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
