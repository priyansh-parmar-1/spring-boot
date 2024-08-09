package com.example.College.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.College.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long>{

	List<Student> findByNameContaining(String name);
	
	Optional<Student> findByName(String name);
}
