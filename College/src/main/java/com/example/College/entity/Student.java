package com.example.College.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	private String name;
	private String email;
	

	@ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	@JoinTable(
	        name = "student_course",
	        joinColumns = {
	            @JoinColumn(name = "sid")
	        },
	        inverseJoinColumns = {
	            @JoinColumn(name = "id")
	        }
	    )
	@JsonIgnoreProperties("students")
	private Set<Course> courses;
	
	
	
	

	public Student(String name, String email, Set<Course> courses) {
		super();
		this.name = name;
		this.email = email;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", email=" + email + ", courses=" + courses + "]";
	}
	
	
	
	
}
