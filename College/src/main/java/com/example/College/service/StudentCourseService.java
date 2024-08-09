package com.example.College.service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.College.entity.Course;
import com.example.College.entity.Student;
import com.example.College.exception.NoRecordsException;
import com.example.College.repository.CourseRepository;
import com.example.College.repository.StudentRepo;
import com.google.common.collect.Lists;

import jakarta.transaction.Transactional;

@Service
public class StudentCourseService {

	@Autowired
	StudentRepo stdRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Transactional
	public boolean addStudent(Student std){
		try {
			HashSet<Course> courses = new HashSet<>();
			for(Course course : std.getCourses()) {
				Course existingCourse = courseRepo.findByTitle(course.getTitle());
				if(existingCourse != null) {
					//using the existing course
					courses.add(existingCourse);
				}else {
					//adding the course if it is new course
					courses.add(course);
				}
			}
			std.setCourses(courses);
			stdRepo.save(std);
		}
		catch(DataAccessException e) {
			System.out.print(e.getMessage());
		}
		return true;
	}
	
	public List<Student> getAll(){
		List<Student> stds = Lists.newArrayList(stdRepo.findAll());
		if(stds.isEmpty()) {
			throw new NoRecordsException("No records for students");
		}
		return stds;
	}
	
	public List<Student> findByName(String name) {
		List<Student> stds = Lists.newArrayList(stdRepo.findByNameContaining(name));
		if(stds.isEmpty()) {
			throw new NoRecordsException("No records for name : "+name);
		}
		return stds;
	}
	
	public void removeByName(String name) {
		Optional<Student> stds = stdRepo.findByName(name);
		if(stds.isEmpty()) {
			throw new NoRecordsException("No data for the name : "+name );
		}
		
		Student std = stds.get();
		
		stdRepo.delete(std);
	}
	
}
