package com.jpamapping.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpamapping.webservice.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer,Integer>{
	
}
