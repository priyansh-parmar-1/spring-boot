package com.example.College.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.College.entity.Student;
import com.example.College.service.StudentCourseService;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

	@Autowired
	StudentCourseService stdCservice;
	
	@PostMapping(value= "/add",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> add(@RequestBody Student std ){
		try {
			return new ResponseEntity<>(stdCservice.addStudent(std),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(){
		try {
			return new ResponseEntity<>(stdCservice.getAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getByName(@PathVariable("name") String name){
		try {
			return new ResponseEntity<>(stdCservice.findByName(name),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/remove/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> removeByName(@PathVariable("name") String name){
		try {
			stdCservice.removeByName(name);
			return new ResponseEntity<>("Removed student "+name+" successfully",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
