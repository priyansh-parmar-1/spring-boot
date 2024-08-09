package com.onetoone.webappOne.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onetoone.webappOne.entity.Department;
import com.onetoone.webappOne.entity.Employee;

public class EmployeeRequest {

	private Employee employee;
	

	public EmployeeRequest( @JsonProperty("name")String name,
							@JsonProperty("department") Department department) {
		super();
		this.employee = new Employee(name,department);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
}
