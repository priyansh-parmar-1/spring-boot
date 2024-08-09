package com.onetoone.webappOne.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onetoone.webappOne.entity.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department,Long>{

}
