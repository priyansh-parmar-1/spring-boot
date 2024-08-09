package com.jpamapping.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpamapping.webservice.dto.OrderRequest;
import com.jpamapping.webservice.entity.Customer;
import com.jpamapping.webservice.repository.CustomerRepo;
import com.jpamapping.webservice.repository.ProductRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepo custRepo;
	@Autowired
	ProductRepo proRepo;
	
	 @PostMapping(name= "place order",value="/placeorder",produces= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request) {
	        try {
	            // Ensure that the Customer object in the OrderRequest is not null
	            if (request.getCustomer() != null) {
	                return new ResponseEntity<>(custRepo.save(request.getCustomer()), HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>("Customer object is null", HttpStatus.BAD_REQUEST);
	            }
	        } catch(Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	@GetMapping(name= "get all orders",value= "/findAllOrders",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAllOrders() {
        try {
            List<Customer> customers = (List<Customer>) custRepo.findAll();
            if(customers.isEmpty()) {
            	return new ResponseEntity<>("Empty", HttpStatus.OK);
            }
            else {
            	return new ResponseEntity<>(customers, HttpStatus.OK);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
