package com.example.College.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.College.dto.StudentRequest;
import com.example.College.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService stdService;
	
	@GetMapping(name="get students",value="/all",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(){
		try {
			return new ResponseEntity<>(stdService.getAllStd(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(name="add students",value="/add",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> add(@RequestBody StudentRequest request){
		try {
			return new ResponseEntity<>(stdService.create(request),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
