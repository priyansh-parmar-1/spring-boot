package com.example.College.dto;

import java.util.List;
import java.util.Set;

import com.example.College.entity.Course;
import com.example.College.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentRequest {

	private Student student;

	public StudentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentRequest(Student student) {
		super();
		this.student = student;
	}

	public StudentRequest(
			@JsonProperty("name") String name,
			@JsonProperty("email") String email,
			@JsonProperty("courses") Set<Course> courses) {
		this.student = new Student(name,email,courses);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
