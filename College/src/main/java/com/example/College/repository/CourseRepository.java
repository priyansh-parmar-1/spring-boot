package com.example.College.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.College.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{

	Course findByTitle(String title);
}
