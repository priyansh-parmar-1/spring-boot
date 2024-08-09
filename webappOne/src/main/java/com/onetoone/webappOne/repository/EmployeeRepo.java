package com.onetoone.webappOne.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onetoone.webappOne.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long>{

}
