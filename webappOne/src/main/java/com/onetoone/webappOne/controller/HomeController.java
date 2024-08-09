package com.onetoone.webappOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onetoone.webappOne.dao.EmployeeRequest;
import com.onetoone.webappOne.entity.Department;
import com.onetoone.webappOne.service.EmployeeService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	EmployeeService empService;
	
	@PostMapping("/add")
	public ResponseEntity<?> createEmp( @RequestBody EmployeeRequest eReq){
		
		return new ResponseEntity<>(empService.createEmployee(eReq),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		
		try {
			return new ResponseEntity<>(empService.getAll(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteByID( @PathVariable Long id){
		
		try {
			empService.delete(id);
			return new ResponseEntity<>("Deleted "+id+" successfully",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("update/{id}/{name}")
	public ResponseEntity<?> updateName( @PathVariable Long id,@PathVariable String name){
		
		try {
			empService.updateName(id, name);
			return new ResponseEntity<>("updated "+id+" successfully",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("update/department/{id}")
	public ResponseEntity<?> updateDepartment( @PathVariable Long id,@RequestBody Department dept){
		
		try {
			empService.updateDepartment(id, dept);
			return new ResponseEntity<>("updated "+id+" successfully",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
