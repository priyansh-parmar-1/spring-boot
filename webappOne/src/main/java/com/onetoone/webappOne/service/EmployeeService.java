package com.onetoone.webappOne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.onetoone.webappOne.dao.EmployeeRequest;
import com.onetoone.webappOne.entity.Department;
import com.onetoone.webappOne.entity.Employee;
import com.onetoone.webappOne.exception.NoRecordsException;
import com.onetoone.webappOne.repository.DepartmentRepo;
import com.onetoone.webappOne.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	DepartmentRepo deptRepo;
	
	//method to create a employee
	public Employee createEmployee(EmployeeRequest req) {
		Employee emp = req.getEmployee();
		empRepo.save(emp);
		return emp;
	}
	
	public List<Employee> getAll(){
		List<Employee> emps = Lists.newArrayList(empRepo.findAll());
		if(emps.isEmpty()) {
			throw new NoRecordsException("No records found");
		}
		return emps;
	}
	
	public void delete(Long id) {
		Optional<Employee> emp =  empRepo.findById(id);
		if(!emp.isPresent()) {
			throw new NoRecordsException("No records found for id : "+id);
		}
		empRepo.deleteById(id);
	}
	
	public void updateName(Long id,String name) {
		Optional<Employee> emp =  empRepo.findById(id);
		if(!emp.isPresent()) {
			throw new NoRecordsException("No records found for name : "+name);
		}
		Employee empobj = emp.get();
		empobj.setName(name);
		empRepo.save(empobj);
	}
	
	public void updateDepartment(Long id,Department dept) {
		Optional<Employee> emp =  empRepo.findById(id);
		if(!emp.isPresent()) {
			throw new NoRecordsException("No records found for name : "+id);
		}
		Employee emp1 = emp.get();
		Department dept1 = emp1.getDepartment();
		dept1.setName(dept.getName());
		deptRepo.save(dept1);
	}
}
