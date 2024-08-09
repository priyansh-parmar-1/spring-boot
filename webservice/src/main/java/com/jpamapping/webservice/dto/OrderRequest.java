package com.jpamapping.webservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpamapping.webservice.entity.Customer;
import com.jpamapping.webservice.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class OrderRequest {

	private Customer customer;

	public OrderRequest(Customer customer) {
		super();
		this.customer = customer;
	}

	public OrderRequest(
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("products") List<Product> products) {
			this.customer = new Customer(name, email, products);
}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
