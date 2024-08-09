package com.publications.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.publications.author.service.AuthorService;
import com.publications.author.vo.OrderRequest;


@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping(name = "Get authors by name and url",value="/all",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAuthors(){
		try {
			return new ResponseEntity<>(authorService.getAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(name= "create author",value="/add",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAuthor(@RequestBody OrderRequest request){
		try {
			return new ResponseEntity<>(authorService.add(request),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(name = "Get suthor by name and url",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAuthor(@RequestParam(name = "name") String name,
			@RequestParam(name = "url") String url){
		try {
			return new ResponseEntity<>(authorService.get(name, url),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}