package com.jpamapping.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpamapping.webservice.entity.Product;

public interface ProductRepo extends CrudRepository<Product,Integer>{

}
